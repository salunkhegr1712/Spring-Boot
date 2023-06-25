package com.banking.Application.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @SequenceGenerator(name = "grs1", sequenceName = "ghansham", initialValue = 3333333, allocationSize = 1)
    @GeneratedValue(generator = "grs1")
    private int account_no;

    //    here we will add a foreign key
    //    the foreign key field have name cust id in account
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer_id;
    private String account_type;
    private String account_status;
    // while transfering json data you have to use customer and in table it will saved as per
    // join column
    private float account_balance;
    @JsonIgnore
    @OneToMany(mappedBy = "account_no")
    private List<Transactions> transactions;

    public Customer getCustomer_id() {
        return customer_id;
    }

    public int grabMycustomerId() {
        return customer_id.getCustomerId();
    }

    public int getAccount_no() {
        return account_no;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public float getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(float account_balance) {
        this.account_balance = account_balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}
