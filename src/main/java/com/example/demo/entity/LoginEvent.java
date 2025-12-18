package com.example.demo.entity;


public class Login {
    private int id;
    private String Name;
    private String Dept;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDept() {
        return Dept;
    }
    
    public void setDept(String dept) {
        Dept = dept;
    }
    public Studententity() {
    }
    public Studententity(int id, String name, String dept) {
        this.id = id;
        Name = name;
        Dept = dept;
    }
    
}