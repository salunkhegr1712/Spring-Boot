package com.example.SpringBasics.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ghansham")
public class Manager {
    @Value("${data.name}")
    String a;

    @GetMapping("/data")
    public String sayHello() {
        return "hello from " + a;
    }
}
