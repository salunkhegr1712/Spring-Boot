package com.banking.Application.Controllers;

import com.banking.Application.Model.LoginDatabase;
import com.banking.Application.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
class OBJ{
    public String username;
    public String newpass;
}

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

}
