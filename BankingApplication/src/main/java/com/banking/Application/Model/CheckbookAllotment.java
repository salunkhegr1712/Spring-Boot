package com.banking.Application.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "checkbooks")
public class CheckbookAllotment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkbook_id;

    public void setAccount_no(int account_no) {
        this.account_no.setAccount_no(account_no);
    }

    @OneToOne
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    private Account account_no;
    private String status;

    public Account getAccount_no() {
        return account_no;
    }

    public int getCheckbook_id() {
        return checkbook_id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
