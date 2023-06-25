package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.GrabTransaction;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transRepo;
    private int trId;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to transaction page</h1>";
    }

    @GetMapping("/data")
    public List<Transactions> getTransactionData() {
        return (List<Transactions>) transRepo.findAll();
    }

    @PostMapping("/new")
    public String CreateNewTransaction(@RequestBody Transactions m) {
        transRepo.save(m);
        return "new transaction done!";
    }

    @PostMapping("/dotransaction")
    public String newTransaction(@RequestBody GrabTransaction a) {
        trId = (int) Math.floor(Math.random() * (2147483647 - 10000000 + 1) + 10000000);
        transRepo.setTransactionValues(trId, a.acc_no, a.amt, a.type, a.date);
        return "transaction take placed successfulley";
    }
}
