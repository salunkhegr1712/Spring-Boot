package com.example.MyApplication.controller;

import com.example.MyApplication.model.Person;
import com.example.MyApplication.model.Student;
import com.example.MyApplication.repository.RepoPerson;
import com.example.MyApplication.repository.RepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Manager {

    @Autowired
    private RepositoryClass m;

    @Autowired
    private RepoPerson repo;

    @GetMapping("/")
    public List<Student> getStudent(){
        return (List<Student>) m.findAll();
    }


    @PostMapping("/data")
    public String addData(@RequestBody Student s){

        m.save(s);
        return "data added successfulley";
    }


    @GetMapping("/person")
    public List<Person> getPerson(){
        return (List<Person>) repo.findAll();
    }

    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person a){
        repo.save(a);
        return "person added successfulley";
    }
}
