package com.ghansham.Security.controller;

import com.ghansham.Security.model.Student;
import com.ghansham.Security.repository.RepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Manager {

//    now lets create the repository here
    @Autowired
    private RepositoryClass repo;

//    do get mapping
    @GetMapping("/server")
    public List<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return (List<Student>) repo.findAll();
    }

    @PostMapping("/data")
    public  Student AddUsers(@RequestBody Student a){

        return  repo.save(a);
    }


//    lets add some text at the homepage
//    private List<Student> a=new ArrayList<>();
//    @GetMapping("/")
//    public String SayHello(){
//        return "<h1>Hello world</h1>";
//    }
//
//    @GetMapping("/users")
//    public List<Student> func(){
//        this.a.add(new Student(1,"ghansham"));
//        this.a.add(new Student(2,"sham"));
//        return this.a;
//    }


}
