package com.insurance.controllers.repo;

import com.insurance.model.database.Catagory;
import com.insurance.model.database.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory,Integer> {

}
