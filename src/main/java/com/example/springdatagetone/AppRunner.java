package com.example.springdatagetone;

import com.example.springdatagetone.app.rest.controller.CustomerController;
import com.example.springdatagetone.app.rest.controller.dto.CustomerDto;
import com.example.springdatagetone.domain.model.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by mtumilowicz on 2018-07-28.
 */
@Component
@AllArgsConstructor
@Slf4j
public class AppRunner implements CommandLineRunner {

    private final CustomerController customerController;

    @Override
    public void run(String... args) {
        log.info("-- updating customer id = 1 ....");
        customerController.update(CustomerDto.builder()
                .id(1)
                .firstName("changed")
                .build());
        log.info("-- update ends");

        log.info("-- retrieving customer id = 1 ....");
        Customer customer = Objects.requireNonNull(customerController.findById(1).getBody());
        log.info("-- retrieved customer id = 1");

        assert Objects.equals(customer.getFirstName(), "changed");
        
        log.info("-- customer.firstName = " + customer.getFirstName());
    }

}
