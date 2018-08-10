package com.example.springdatagetone.domain.service;

import com.example.springdatagetone.app.facade.CustomerReadOnlyQueryFacade;
import com.example.springdatagetone.domain.model.Customer;
import com.example.springdatagetone.infrastructure.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CustomerService {
    
    CustomerReadOnlyQueryFacade readOnlyQueryFacade;
    CustomerRepository customerRepository;
    
    @Transactional
    public void update(Customer customer) {
        log.info("---- before getOne");
        Customer toUpdate = readOnlyQueryFacade.getOne(customer.getId());
        log.info("---- after getOne");
        
        if (nonNull(customer.getFirstName())) {
            log.info("------ before updating...");
            toUpdate.updateFrom(customer);
            log.info("------ after updating...");
        }

        log.info("---- saving to database...");
        customerRepository.save(toUpdate);
    }

    public List<Customer> findAll() {
        return readOnlyQueryFacade.findAll();
    }

    public Customer findById(int id) {
        return readOnlyQueryFacade.findById(id).orElseThrow(() -> 
                new EntityNotFoundException("Customer with id = " + id + " cannot be found"));
    }
}
