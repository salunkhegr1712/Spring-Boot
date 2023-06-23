package com.example.MyApplication.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PersonData")
@NoArgsConstructor
public class Person {
    private String fname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personID;
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    private String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
}
