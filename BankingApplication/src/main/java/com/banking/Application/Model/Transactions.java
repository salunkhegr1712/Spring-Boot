package com.banking.Application.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @SequenceGenerator(name = "transactionid", sequenceName = "transactions", initialValue = 98700, allocationSize = 1)
    @GeneratedValue(generator = "transactionid")
    private int transaction_id;

    @ManyToOne
    @JoinColumn(name = "Source_account_no")
    private Account account_no;
    private double transaction_amount;
    private String date;
    private String type;
    private int target_account_no;

    public int getTarget_account_no() {
        return target_account_no;
    }

    public void setTarget_account_no(int target_account_no) {
        this.target_account_no = target_account_no;
    }


    public int getTransaction_id() {
        return transaction_id;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccount_no(Account account_no) {
        this.account_no = account_no;
    }


}
