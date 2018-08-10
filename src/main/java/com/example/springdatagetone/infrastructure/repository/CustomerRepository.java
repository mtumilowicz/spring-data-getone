package com.example.springdatagetone.infrastructure.repository;

import com.example.springdatagetone.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
