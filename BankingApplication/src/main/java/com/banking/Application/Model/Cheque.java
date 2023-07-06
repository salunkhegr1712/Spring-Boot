package com.banking.Application.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "cheque")
public class Cheque {

    @Id
    @SequenceGenerator(name = "blah1", sequenceName = "blah1", initialValue = 88888888, allocationSize = 1)
    @GeneratedValue(generator = "blah1")
    private int checque_id;

    private double amount;
    private String reciptantName;
    private String date;

    public int getChecque_id() {
        return checque_id;
    }

    public void setChecque_id(int checque_id) {
        this.checque_id = checque_id;
    }

//    public CheckbookAllotment getCheckbook_id() {
//        return checkbook_id;
//    }
//
//    public void setCheckbook_id(CheckbookAllotment checkbook_id) {
//        this.checkbook_id = checkbook_id;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReciptantName() {
        return reciptantName;
    }

    public void setReciptantName(String reciptantName) {
        this.reciptantName = reciptantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
