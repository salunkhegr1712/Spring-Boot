package com.banking.Application.Controllers;

import com.banking.Application.Model.AdminDatabase;
import com.banking.Application.Model.LoginDatabase;
import com.banking.Application.Repository.AdminDbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/admindb")
public class AdminDBController {
    @Autowired
    AdminDbRepo adrepo;

    @GetMapping("/")
    public String firstPage(){
        return "hello world";
    }

    @PostMapping("/addStaff")
    public String addStaff(@RequestBody AdminDatabase a){
        adrepo.save(a);
        return  "data added successfulley";

    }
    @GetMapping("/data")
    public List<AdminDatabase> getData(){
        return (List<AdminDatabase>) adrepo.findAll();
    }

    @GetMapping("/getrole/{username}")
    public AdminDatabase getRole(@PathVariable String username ){
        return  adrepo.getRoleFromUsername(username);
    }
    @GetMapping("/search/{user}")
    public boolean searchusername(@PathVariable String user){
        try {
            AdminDatabase a= adrepo.searchByUsername(user).get(0);
            return false;
        }
        catch (Exception a){
            return true;
        }
    }
}
