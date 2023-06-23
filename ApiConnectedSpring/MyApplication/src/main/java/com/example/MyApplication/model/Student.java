package com.example.MyApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="grs")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;
    public int getMis() {
        return mis;
    }

    public void setMis(int mis) {
        this.mis = mis;
    }

    private int mis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int mis, String name) {
        this.mis = mis;
        this.name = name;
    }

    public Student() {
    }

    private String name;

}
