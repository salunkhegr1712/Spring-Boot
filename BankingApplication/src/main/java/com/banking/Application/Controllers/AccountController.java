package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.RegisterClass;
import com.banking.Application.Model.Account;
import com.banking.Application.Model.Customer;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/account")
public class AccountController {

//    here get service;

    @Autowired
    service serv;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to account page</h1>";
    }

    //    mapping for account
    @GetMapping("/data")
    public List<Account> getAccountData() {
        return serv.getAccountData();
    }

    @GetMapping("/data/{mydata}")
    public Account getMyAccountData(@PathVariable int mydata) {
        return serv.getMyAccountData(mydata);
    }

    @PostMapping("/createAccount")
    public String CreateAccount(@RequestBody Account cust) {

        serv.saveInAccountRepo(cust);
        return "New account Added";
    }

    @GetMapping("/transactions/{idd}")
    public List<Transactions> getSpecific(@PathVariable int idd) {
        return serv.getSpecific(idd);
    }

    @PostMapping("/register")
    public String newRegistration(@RequestBody RegisterClass rc) {

        serv.newRegistration(rc);
        return "new account created successfulley!";
    }

    @GetMapping("/delete/{acc_no}")
    public boolean deleteAccount(@PathVariable int acc_no) {
        return deleteAccount(acc_no);
    }

    @GetMapping("/status/{requested}")
    public List<Account> getAllPendingAccounts(@PathVariable String requested) {
        return serv.getAllPendingAccounts(requested);
    }

    @GetMapping("/getname/{acc}")
    public Customer getCustomerFromAccountNo(@PathVariable int acc) {
        return serv.getCustomerFromAccountNo(acc);
    }

    @GetMapping("/search/{user}")
    public boolean searchusername(@PathVariable int user) {
        return serv.searchusername(user);
    }

    @GetMapping("/makeaccountactive/{account_no}")
    public boolean MakeAccountActive(@PathVariable int account_no) {
        serv.MakeAccountActive(account_no);
        return true;
    }
}
