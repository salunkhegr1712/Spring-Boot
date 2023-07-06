package com.banking.Application.Controllers;

import com.banking.Application.Model.AdminDatabase;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admindb")
public class AdminDBController {

    //    in each controller you have to import the service
    @Autowired
    service serv;

    @GetMapping("/")
    public String firstPage() {
        return "hello world";
    }

    @PostMapping("/addStaff")
    public boolean addStaff(@RequestBody AdminDatabase a) {
        serv.saveInAdminDB(a);
        return true;

    }

    @GetMapping("/data")
    public List<AdminDatabase> getData() {
        return serv.getData();
    }

    @GetMapping("/getrole/{username}")
    public AdminDatabase getRole(@PathVariable String username) {

        return serv.getRole(username);
    }

    @GetMapping("/search/{user}")
    public boolean searchusername(@PathVariable String user) {
        return serv.searchusernameAdminDB(user);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteEntry(@PathVariable int id) {
        serv.deleteEntryAdminDB(id);
        return true;
    }
}
