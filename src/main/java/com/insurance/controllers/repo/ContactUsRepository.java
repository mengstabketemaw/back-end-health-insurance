package com.insurance.controllers.repo;

import com.insurance.model.database.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUs,Integer> {

}
