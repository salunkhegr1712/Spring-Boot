package com.ghansham.Security.model;

import jakarta.persistence.*;

@Entity
@Table(name="student1")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  int id;
    public String getMis() {
        return mis;
    }

    public void setMis(String mis) {
        this.mis = mis;
    }

    private  String mis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

//    also create a constructor
    public Student(String a, String b){
        this.mis=a;
        this.name=b;
    }
    public Student(){
        this.mis="blah";
        this.name="blah";
    }
}
