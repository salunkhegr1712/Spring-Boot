package com.banking.Application.Model;

import com.banking.Application.Repository.CheckbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheque")
public class ChequeController {

    @Autowired
    CheckbookRepo chequeRepo;

    @GetMapping("/transactions")
    public Iterable<CheckbookAllotment> getAllChequeTransactions() {
        return chequeRepo.findAll();
    }


}
