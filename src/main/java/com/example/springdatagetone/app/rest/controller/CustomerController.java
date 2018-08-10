package com.example.springdatagetone.app.rest.controller;

import com.example.springdatagetone.app.rest.controller.assembler.CustomerAssembler;
import com.example.springdatagetone.app.rest.controller.dto.CustomerDto;
import com.example.springdatagetone.domain.model.Customer;
import com.example.springdatagetone.domain.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("customers")
public class CustomerController {
    
    CustomerService customerService;
    
    @PutMapping
    public void update(@RequestBody CustomerDto dto) {
        customerService.update(CustomerAssembler.toEntity(dto));
    }
    
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("{id}")
    public Customer findById(@PathVariable("id") int id) {
        return customerService.findById(id);
    }

    @GetMapping("health")
    public void health() {}
}
