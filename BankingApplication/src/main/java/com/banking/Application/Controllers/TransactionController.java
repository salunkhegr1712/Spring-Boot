package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.GrabTransaction;
import com.banking.Application.Model.Transactions;
import com.banking.Application.Repository.AccountRepo;
import com.banking.Application.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transRepo;

    @Autowired
    AccountRepo account_repo;
    private int trId;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to transaction page</h1>";
    }

    @GetMapping("/data")
    public List<Transactions> getTransactionData() {
        return (List<Transactions>) transRepo.findAll();
    }

    @PostMapping("/dotransaction")
    public String newTransaction(@RequestBody GrabTransaction a) {
        trId = (int) Math.floor(Math.random() * (2147483647 - 10000000 + 1) + 10000000);
        transRepo.setTransactionValues(trId, a.source_account_no, a.amount, a.target_account_no, a.type, a.date);

        account_repo.updateAccountBalanceUsingAccountNO(account_repo.getAccountDetails(a.source_account_no).getAccount_balance() - a.amount, a.source_account_no);

        trId = (int) Math.floor(Math.random() * (2147483647 - 10000000 + 1) + 10000000);
        transRepo.setTransactionValues(trId, a.target_account_no, a.amount, a.source_account_no, "deposit", a.date);
        account_repo.updateAccountBalanceUsingAccountNO(account_repo.getAccountDetails(a.target_account_no).getAccount_balance() + a.amount, a.target_account_no);
        return "transaction take placed successfulley";
    }

    @GetMapping("/gettransaction/{trId}")
    public Transactions getTransactionFromId(@PathVariable int trId) {
        return transRepo.getTransactionById(trId);
    }
}
