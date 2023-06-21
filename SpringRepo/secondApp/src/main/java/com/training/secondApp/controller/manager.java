package com.training.secondApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class manager {

    @GetMapping("/")
    public String func(){
        return "<h1>hello there!</h1>";
    }

    @GetMapping("/grs")
    public String func1(){
        return "<h1>hello there! I am Ghansham here</h1>";
    }
}
