package com.example.springdatagetone.app.facade;

import com.example.springdatagetone.domain.model.Customer;
import com.example.springdatagetone.infrastructure.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
public class CustomerReadOnlyQueryFacade {
    
    CustomerRepository customerRepository;
    
    public Customer getOne(int id) {
        return customerRepository.getOne(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
