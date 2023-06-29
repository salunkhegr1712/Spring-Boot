package com.banking.Application.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loginDB")
@NoArgsConstructor
@AllArgsConstructor
public class LoginDatabase {

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    private Account account_no;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_no() {
        return account_no.getAccount_no();
    }

    public void setAccount_no(Account account_no) {
        this.account_no = account_no;
    }


}
