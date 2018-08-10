package com.example.springdatagetone.domain.service;

import com.example.springdatagetone.app.facade.CustomerReadOnlyQueryFacade;
import com.example.springdatagetone.domain.model.Customer;
import com.example.springdatagetone.infrastructure.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    
    CustomerReadOnlyQueryFacade readOnlyQueryFacade;
    CustomerRepository customerRepository;
    
    public void update(Customer customer) {
        System.out.println("---- before getOne");
        Customer toUpdate = readOnlyQueryFacade.getOne(customer.getId());
        System.out.println("---- after getOne");
        
        if (nonNull(customer.getFirstName())) {
            System.out.println("------ before updating...");
            toUpdate.updateFrom(customer);
            System.out.println("------ after updating...");
        }

        System.out.println("---- saving to database...");
        customerRepository.save(toUpdate);
    }

    public List<Customer> findAll() {
        return readOnlyQueryFacade.findAll();
    }
}
