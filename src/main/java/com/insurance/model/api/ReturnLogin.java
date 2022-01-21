package com.insurance.model.api;



public class ReturnLogin {

    private String name;
    private int id;


    public ReturnLogin(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public ReturnLogin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
