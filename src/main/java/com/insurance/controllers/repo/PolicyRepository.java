package com.insurance.controllers.repo;

import com.insurance.model.database.Customer;
import com.insurance.model.database.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy,Integer> {

}
