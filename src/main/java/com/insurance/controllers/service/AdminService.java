package com.insurance.controllers.service;

import com.insurance.controllers.repo.*;
import com.insurance.model.api.AvailablePolicy;
import com.insurance.model.database.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminService {

    final PolicyRepository policyRepository;
    final CustomerRepository customerRepository;
    final CatagoryRepository catagoryRepository;
    final QuestionRepository questionRepository;
    final AppliedPolicyRepository appliedPolicyRepository;
    final ContactUsRepository contactUsRepository;

    public AdminService(PolicyRepository policyRepository,
                        CustomerRepository customerRepository,
                        CatagoryRepository catagoryRepository,
                        QuestionRepository questionRepository,
                        ContactUsRepository contactUsRepository,
                        AppliedPolicyRepository appliedPolicyRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
        this.catagoryRepository = catagoryRepository;
        this.questionRepository = questionRepository;
        this.appliedPolicyRepository = appliedPolicyRepository;
        this.contactUsRepository = contactUsRepository;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Map<String,Object>>> allCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<Map<String,Object>> customerList = new ArrayList<>();
        for(Customer customer : customers) {
            Map<String, Object> cust = new HashMap<>();
            cust.put("id",customer.getId());
            cust.put("fullname",customer.getFullname());
            cust.put("email",customer.getEmail());
            cust.put("phone",customer.getPhone());
            customerList.add(cust);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerList);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam int customerid){
        boolean exist = customerRepository.existsById(customerid);
        if(exist)
        customerRepository.deleteById(customerid);
        else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/appliedpolicies")
    public ResponseEntity<List<AppliedPolicy>> allAppliedPolicy(){
        List<AppliedPolicy> policyList = appliedPolicyRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(policyList);
    }

    @GetMapping("/deleteappliedpolicy")
    public ResponseEntity<String> deleteAppliedPolicy(@RequestParam int policyid){
        boolean exist = appliedPolicyRepository.existsById(policyid);
        if(exist)
        appliedPolicyRepository.deleteById(policyid);
        else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/approve")
    public ResponseEntity<String> approve(@RequestParam int policyid){
        boolean exist = appliedPolicyRepository.existsById(policyid);
        if(exist){
            AppliedPolicy appliedPolicy = appliedPolicyRepository.getById(policyid);
            appliedPolicy.setStatus("Approved");
            appliedPolicyRepository.save(appliedPolicy);
        }
        else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/disapprove")
    public ResponseEntity<String> disapprove(@RequestParam int policyid){
        boolean exist = appliedPolicyRepository.existsById(policyid);
        if(exist){
        AppliedPolicy appliedPolicy = appliedPolicyRepository.getById(policyid);
        appliedPolicy.setStatus("Disapproved");
        appliedPolicyRepository.save(appliedPolicy);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/deletepolicy")
    public ResponseEntity<String> deletePolicy(@RequestParam int policyid){
        boolean exist = appliedPolicyRepository.existsById(policyid);
        if(exist){
        policyRepository.deleteById(policyid);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/addpolicy")
    public ResponseEntity<String> addPolicy(@RequestBody AvailablePolicy availablePolicy){
        Policy policy = new Policy();
        policy.setCatagory(availablePolicy.getCatagory());
        policy.setName(availablePolicy.getName());
        policy.setPremium(availablePolicy.getPremium());
        policy.setTenure(availablePolicy.getTenure());
        policyRepository.save(policy);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllAskedQuestions(){
        List<Question> questions = questionRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @GetMapping("/answer")
    public ResponseEntity<String> answer(@RequestParam String comment,@RequestParam int questionid ){
        Question question = questionRepository.getById(questionid);
        question.setComment(comment);
        questionRepository.save(question);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/comment")
    public ResponseEntity<List<ContactUs>> customerCommentOnTheSystem(){
        List<ContactUs> comments = contactUsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }


}
