package com.ghansham.myApp.controller;

import com.ghansham.myApp.User.UserClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FunRestController {

    private  List<UserClass> database1=new ArrayList<>();
    private int z=0;


//    we are added some code inside application.properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${player.name}")
    private String playerName;
//    inside this we are going to write code which will display on main page
    @GetMapping("/")
    public String sayHelloFunction(){
        return "<div style='color:white;background-color:red;margin:auto'><h1>hello World</h1><br><h1>"+coachName+"</h1><br><h1>"+playerName+"</h1></div>";
    }

    @GetMapping("/sham")
    public List<UserClass> getDetails(){

        if(z==0){
            database1.add(new UserClass("sham",111903033));
            database1.add(new UserClass("ghansham",111903093));
            database1.add(new UserClass("ritik",111903013));
            database1.add(new UserClass("abhishek",111903003));
            database1.add(new UserClass());
            z++;
        }

        return database1;
    }
    @PostMapping("/addCandidate")
    public  String AddCandidateInList(@RequestBody UserClass a){
        database1.add(a);
        return  "added succcesfulley";
    }

}
