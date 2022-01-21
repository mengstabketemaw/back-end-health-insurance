package com.insurance.model.api;

public class AvailablePolicy {
    private int id;
    private String name;
    private String catagory;
    private double premium;
    private double tenure;



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

    public String getCatagory() {
        return catagory;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getTenure() {
        return tenure;
    }

    public void setTenure(double tenure) {
        this.tenure = tenure;
    }
}
