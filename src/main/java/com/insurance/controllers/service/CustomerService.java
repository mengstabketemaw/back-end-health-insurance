package com.insurance.controllers.service;

import com.insurance.controllers.repo.*;
import com.insurance.model.database.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerService {
    Logger logger = Logger.getLogger(CustomerService.class.getName());

    final PolicyRepository policyRepository;
    final CustomerRepository customerRepository;
    final CatagoryRepository catagoryRepository;
    final QuestionRepository questionRepository;
    final AppliedPolicyRepository appliedPolicyRepository;


    public CustomerService(PolicyRepository policyRepository, CustomerRepository customerRepository, CatagoryRepository catagoryRepository, QuestionRepository questionRepository, AppliedPolicyRepository appliedPolicyRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
        this.catagoryRepository = catagoryRepository;
        this.questionRepository = questionRepository;
        this.appliedPolicyRepository = appliedPolicyRepository;
    }

    @GetMapping("/available")
    public ResponseEntity<List<Policy>> availablePolicies(){
        List<Policy> policies = policyRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(policies);
    }

    @GetMapping("/{user}/applied")
    public ResponseEntity<List<AppliedPolicy>> appliedPolicies(@PathVariable int user){
       Customer customer;
        boolean exist = customerRepository.existsById(user);
        if(exist)
          customer = customerRepository.getById(user);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       return ResponseEntity.status(HttpStatus.OK).body(customer.getPolicies());
    }

    @GetMapping("/catagory")
    public ResponseEntity<List<Catagory>> catagoryOfPolicies(){
        List<Catagory> catagories = catagoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(catagories);
    }

    @GetMapping("/{user}/questions")
    public ResponseEntity<List<Question>> allAskedQuesions(@PathVariable int user){
        if(customerRepository.existsById(user)){
        Customer customer = customerRepository.getById(user);
        return ResponseEntity.status(HttpStatus.OK).body(customer.getQuestions());}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{user}/ask")
    public ResponseEntity<String> askQuestion(@PathVariable int user,@RequestParam String question ){
        if(!customerRepository.existsById(user))return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Question question1 = new Question();
        question1.setCustomer_name(customerRepository.getById(user).getFullname());
        question1.setQuestion(question);
        question1.setCustomer_id(user);
        question1.setDate(new Date().toString());
        questionRepository.save(question1);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{user}/apply")
    public ResponseEntity<String> applyPolicy(@PathVariable int user,@RequestParam String policy){
        if(!customerRepository.existsById(user))return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        AppliedPolicy appliedPolicy = new AppliedPolicy();
        appliedPolicy.setPolicy(policy);
        appliedPolicy.setCustomer_name(customerRepository.getById(user).getFullname());
        appliedPolicy.setStatus("Waiting");
        appliedPolicy.setDate(new Date().toString());
        appliedPolicy.setCustomer_id(user);
        appliedPolicyRepository.save(appliedPolicy);

        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
