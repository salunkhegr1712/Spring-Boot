package com.example.Application.model;

import jakarta.persistence.*;

@Entity
@Table(name="vishal")
public class Person {
    public Person() {
        this.fname = "blah";
        this.lname = "blah";
    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    private String fname;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String lname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;
}
