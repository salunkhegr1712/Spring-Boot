package com.banking.Application.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //    creating a customer repo

    @GetMapping("/")
    public String HomePage() {
        return "<div style='background-color:red;color:white;margin:auto;text-align:center;padding:20px;'>" +
                "<h1>Welcome to Banking Application</h1>"
                + "</div>";
    }

}

