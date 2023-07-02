package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.OBJ;
import com.banking.Application.Model.LoginDatabase;
import com.banking.Application.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepo lgRepo;


    @GetMapping("/data")
    public List<LoginDatabase> getLogins(){

        return (List<LoginDatabase>) lgRepo.findAll();
    }

    @PostMapping("/")
    public String addLoginData(@RequestBody LoginDatabase a){

        lgRepo.save(a);
        return "login database updated";
    }


    @PostMapping("/changepassword")
    public  String changePassword(@RequestBody OBJ a){
        List<LoginDatabase>c= lgRepo.searchUsername(a.username);
        if (c.size()==0){
            return  "data not found";
        }
        lgRepo.updatePassword(c.get(0).getAccount_no(),a.newpass);
        return "data found and updated successfulley";
    }

    @GetMapping("/search/{user}")
    public boolean searchusername(@PathVariable String user){
        try {
            LoginDatabase a= lgRepo.searchByUsername(user).get(0);
            return false;
        }
        catch (Exception a){
            return true;
        }
    }

    @GetMapping("/getpassword/{username}")
    public LoginDatabase getPassword(@PathVariable String username){
        try{
            return lgRepo.getPasswordFromUsername(username);
        }
        catch (Exception e){
            return new LoginDatabase();
        }
    }

    @GetMapping("/getrole/{username}")
    public LoginDatabase getRole(@PathVariable String username ){
        return  lgRepo.getRoleFromUsername(username);
    }

}
