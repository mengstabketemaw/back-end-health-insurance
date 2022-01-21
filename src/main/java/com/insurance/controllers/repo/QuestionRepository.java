package com.insurance.controllers.repo;

import com.insurance.model.database.Customer;
import com.insurance.model.database.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
