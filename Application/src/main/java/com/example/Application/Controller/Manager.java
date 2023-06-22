package com.example.Application.Controller;

import com.example.Application.model.Person;
import com.example.Application.repository.RepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Manager {

    @GetMapping("/")
    public String sayHello(){
        return "<h1>hello world</h1>";
    }

    @Autowired
    private RepositoryClass repo;

    @GetMapping("/users")
    public List<Person> showPeople(){
        return (List<Person>) repo.findAll();
    }
    @PostMapping("/addPerson")
    public String addPeopleFunction(@RequestBody Person a){
        repo.save(a);
        return "data added successfulley";
    }


}
