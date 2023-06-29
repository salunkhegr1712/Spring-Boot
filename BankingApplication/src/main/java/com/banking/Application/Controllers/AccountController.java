package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.CustData;
import com.banking.Application.Controllers.RequiredClasses.RegisterClass;
import com.banking.Application.Model.Account;
import com.banking.Application.Model.LoginDatabase;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Repository.AccountRepo;
import com.banking.Application.Repository.CustomerRepo;
import com.banking.Application.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    LoginRepo lgr;

    @Autowired
    CustomerRepo custRepo;

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
        Account a = accountRepo.getAccountDetails(3333333);
        accountRepo.updateAccountBalanceUsingCustomerId(a.getAccount_balance() - 10000, a.grabMycustomerId());
        return "updated balance : " + a.getAccount_balance();
    }

    @GetMapping("/deposits")
    public String depositMoney(@RequestBody int amount, @RequestBody int account_no) {
        Account a = accountRepo.getAccountDetails(account_no);
        accountRepo.updateAccountBalanceUsingCustomerId(a.getAccount_balance() + amount, a.grabMycustomerId());
        return "updated balance : " + a.getAccount_balance();
    }

    @GetMapping("/transactions/{idd}")
    public List<Transactions> getSpecific(@PathVariable int idd) {
        List<Transactions> a = accountRepo.getAccountDetails(idd).getTransactions();

        if (a.size() == 0) {
            return new ArrayList<>();
        }
        return a;
    }
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {

        return accountRepo.getAccountDetails(3333336).getTransactions();
    }

    @PostMapping("/register")
    public String newRegistration(@RequestBody RegisterClass rc){
        accountRepo.save(rc.account);
        LoginDatabase s=new LoginDatabase();
        s.setAccount_no(rc.account);
        s.setPassword(rc.password);
        s.setUsername(rc.username);
        s.setRole(rc.role);
        lgr.save(s);
        return "new account created successfulley!";
    }

    @GetMapping("/delete/{acc_no}")
    public String deleteAccount(@PathVariable int acc_no){
        accountRepo.func1();
        custRepo.deleteRowFromTable(accountRepo.getCustomerIdFromAccount(acc_no));
        accountRepo.deleteRowFromTable(acc_no);
        accountRepo.func2();
        return "data deleted successfulley!";
    }
}
