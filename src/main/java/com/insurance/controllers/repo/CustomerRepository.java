package com.insurance.controllers.repo;

import com.insurance.model.database.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerByEmail(String email);
    Customer findCustomersByPhone(double phone);
}
