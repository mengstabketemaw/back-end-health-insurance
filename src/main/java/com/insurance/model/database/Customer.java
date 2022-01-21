package com.insurance.model.database;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    String fullname;

    @Column(unique = true,nullable = false)
    String email;

    @Column(unique = true,nullable = false)
    double phone;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    List<AppliedPolicy> policyList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    List<Question> questions = new ArrayList<>();

    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public List<AppliedPolicy> getPolicies() {
        return policyList;
    }

    public void setPolicies(List<AppliedPolicy> policies) {
        this.policyList = policies;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
