package com.example.DevtoolsWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Manager {

    private Coach mycoach;

    @Autowired
    public Manager(Coach my) {
        this.mycoach = my;
    }

    @GetMapping("/coach")
    public String Workout(){
        return  mycoach.workout();
    }
}
