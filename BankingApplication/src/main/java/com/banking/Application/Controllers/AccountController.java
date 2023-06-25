package com.banking.Application.Controllers;

import com.banking.Application.Model.Account;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to account page</h1>";
    }

    //    mapping for account
    @GetMapping("/data")
    public List<Account> getAccountData() {
        return (List<Account>) accountRepo.findAll();
    }

    @GetMapping("/data/{mydata}")
    public Account getMyAccountData(@PathVariable int mydata) {
        return accountRepo.getAccountDetails(mydata);
    }

    @PostMapping("/createAccount")
    public String CreateAccount(@RequestBody Account cust) {

        accountRepo.save(cust);
        return "New account Added";
    }

    @GetMapping("/withdraw")
    public String withdrawMoney() {
        Account a = accountRepo.getAccountDetails(33334);
        accountRepo.updateAccountBalance(a.getAccount_balance() - 10000, a.grabMycustomerId());
        return "updated balance : " + a.getAccount_balance();
    }

    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {

        return accountRepo.getAccountDetails(117127).getTransactions();
    }
}
