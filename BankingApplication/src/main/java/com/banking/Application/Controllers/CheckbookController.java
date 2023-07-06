package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.GrabCheckbookStatus;
import com.banking.Application.Model.CheckbookAllotment;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/checkbook")
public class CheckbookController {

    @Autowired
    service serve;

    @GetMapping("/")
    public String HomePage() {

        return "<h1> welcome to Checkbook page</h1>";
    }

    @GetMapping("/status")
    public List<CheckbookAllotment> GetAllCheckbookData() {
        return serve.getAllChequeData();
    }

    @GetMapping("/createnew/{acc}")
    public boolean checkbookAddition(@PathVariable int acc) {

        return serve.checkbookAddition(acc);
    }

    @PostMapping("/updatestatus")
    public String updateCheckbookStatus(@RequestBody GrabCheckbookStatus a) {
        serve.updateCheckbookStatus(a);
        return "checkbook status updated";
    }

    @GetMapping("/getcheckbook/{acc}")
    public CheckbookAllotment getCheckbookData(@PathVariable int acc) {
        return serve.getCheckbookData(acc);
    }

    @GetMapping("/requested")
    public List<CheckbookAllotment> getRequested() {
        return serve.getRequested();
    }

    @GetMapping("/makecheckbookactive/{acc}")
    public boolean makecheckbookactive(@PathVariable int acc) {

        return serve.makecheckbookactive(acc);
    }
}
