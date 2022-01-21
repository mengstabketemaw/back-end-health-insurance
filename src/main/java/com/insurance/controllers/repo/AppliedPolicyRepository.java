package com.insurance.controllers.repo;

import com.insurance.model.database.AppliedPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppliedPolicyRepository extends JpaRepository<AppliedPolicy,Integer> {

}
