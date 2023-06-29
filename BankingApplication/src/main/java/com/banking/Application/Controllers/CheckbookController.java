package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.GrabCheckbookStatus;
import com.banking.Application.Model.CheckbookAllotment;
import com.banking.Application.Repository.CheckbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/checkbook")
public class CheckbookController {

    @Autowired
    CheckbookRepo checkRepo;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to Checkbook page</h1>";
    }

    @GetMapping("/status")
    public List<CheckbookAllotment> GetAllCheckbookData() {

        return (List<CheckbookAllotment>) checkRepo.findAll();
    }

    @PostMapping("/createnew")
    public String checkbookAddition(@RequestBody CheckbookAllotment a) {

        checkRepo.save(a);
        return "checkbook transaction done!";
    }

    @PostMapping("/updatestatus")
    public String updateCheckbookStatus(@RequestBody GrabCheckbookStatus a) {
        checkRepo.updateCheckbookStatus(a.account_no, a.status);
        return "checkbook status updated";
    }
}
