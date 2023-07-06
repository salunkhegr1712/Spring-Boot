package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.GrabTransaction;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    service serve;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to transaction page</h1>";
    }

    @GetMapping("/data")
    public List<Transactions> getTransactionData() {
        return serve.getTransactionData();
    }

    @PostMapping("/dotransaction")
    public String newTransaction(@RequestBody GrabTransaction a) {
        return serve.newTransaction(a);
    }

    @GetMapping("/gettransaction/{trId}")
    public Transactions getTransactionFromId(@PathVariable int trId) {
        return serve.getTransactionFromId(trId);
    }
}
