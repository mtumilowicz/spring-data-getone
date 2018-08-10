package com.example.springdatagetone.infrastructure.repository;

import com.example.springdatagetone.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
