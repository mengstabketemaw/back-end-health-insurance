package com.insurance.controllers.service;


import com.insurance.controllers.repo.ContactUsRepository;
import com.insurance.controllers.repo.CustomerRepository;
import com.insurance.model.api.*;
import com.insurance.model.database.ContactUs;
import com.insurance.model.database.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeService {

    private final CustomerRepository cr;
    private final ContactUsRepository contact;

    public HomeService(CustomerRepository cr,ContactUsRepository ct) {
        this.cr = cr;
        contact=ct;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Signup signup){
        Customer customer = new Customer();
        customer.setEmail(signup.getEmail());
        customer.setFullname(signup.getName());
        customer.setPhone(signup.getPhone());
        customer.setPassword(signup.getPassword());
        cr.save(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<ReturnLogin> login(@RequestBody Login login){

        if(login.getName().equals("admin")){
            if(login.getPassword().equals("admin"))
                return ResponseEntity.status(HttpStatus.OK).body(new ReturnLogin("admin",0));
            else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        Customer customer = cr.findCustomerByEmail(login.getName());
        if(customer.getPassword().equals(login.getPassword()))
            return ResponseEntity.status(HttpStatus.OK).body(new ReturnLogin(customer.getFullname(),customer.getId()));
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @PostMapping("/forgetpassword")
    public ResponseEntity<Map<String, Object>> forgetPassword(@RequestBody ForgetPassword forgetPassword){
        Customer customer = cr.findCustomersByPhone(forgetPassword.getPhone());
        if(customer!=null)
            return  ResponseEntity.status(200).body(Collections.singletonMap("password",customer.getPassword()));
        return ResponseEntity.status(404).body(Collections.singletonMap("password","there is no password dud, try again with another phone no."));
    }

    @PostMapping("/contactus")
    public ResponseEntity<String> contactus(@RequestBody Contactus contactus){
        ContactUs con = new ContactUs();
        con.setComment(contactus.getComment());
        con.setName(contactus.getEmail());
        contact.save(con);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
