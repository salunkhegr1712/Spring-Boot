package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.OBJ;
import com.banking.Application.Model.LoginDatabase;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    service serve;

    @GetMapping("/data")
    public List<LoginDatabase> getLogins() {
        return serve.getLogins();
    }

    @PostMapping("/")
    public String addLoginData(@RequestBody LoginDatabase a) {

        serve.saveInLoginRepo(a);
        return "login database updated";
    }


    @PostMapping("/changepassword")
    public String changePassword(@RequestBody OBJ a) {

        return serve.changePassword(a);
    }

    @GetMapping("/search/{user}")
    public boolean searchusername(@PathVariable String user) {
        return serve.searchByusername(user);
    }

    @GetMapping("/getpassword/{username}")
    public LoginDatabase getPassword(@PathVariable String username) {
        return serve.getPassword(username);
    }

    @GetMapping("/getrole/{username}")
    public LoginDatabase getRoleLoginDB(@PathVariable String username) {
        return serve.getRoleLoginDB(username);
    }

    @PostMapping("/updatepassword")
    public boolean updatePass(@RequestBody grabPass m) {

        return serve.updatePass(m);
    }
}
