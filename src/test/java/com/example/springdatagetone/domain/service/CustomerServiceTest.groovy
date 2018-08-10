package com.example.springdatagetone.domain.service

import com.example.springdatagetone.app.facade.CustomerReadOnlyQueryFacade
import com.example.springdatagetone.domain.model.Customer
import com.example.springdatagetone.infrastructure.repository.CustomerRepository
import spock.lang.Specification

import javax.persistence.EntityNotFoundException

/**
 * Created by mtumilowicz on 2018-08-10.
 */
class CustomerServiceTest extends Specification {
    def "test update"() {
        given:
        def customerFromDatabase = Customer.builder()
                .id(1)
                .build()

        and:
        def customerReadOnlyQueryFacade = Mock(CustomerReadOnlyQueryFacade)

        and:
        def customerRepository = Mock(CustomerRepository)

        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("changed")
                .build()

        and:
        def customerToSave = Customer.builder()
                .id(1)
                .firstName("changed")
                .build()

        when:
        new CustomerService(customerReadOnlyQueryFacade, customerRepository).update(customer)

        then:
        1 * customerReadOnlyQueryFacade.getOne(1) >> customerFromDatabase
        1 * customerRepository.save(customerToSave as Customer)
    }

    def "test findAll"() {
        given:
        def customerReadOnlyQueryFacade = Mock(CustomerReadOnlyQueryFacade)

        when:
        new CustomerService(customerReadOnlyQueryFacade, Mock(CustomerRepository)).findAll()

        then:
        1 * customerReadOnlyQueryFacade.findAll()
    }
    
    def "test findById found"() {
        given:
        def customerReadOnlyQueryFacade = Mock(CustomerReadOnlyQueryFacade) {
            findById(1) >> Optional.of(Mock(Customer))
        }

        expect:
        new CustomerService(customerReadOnlyQueryFacade, Mock(CustomerRepository)).findById(1)
    }

    def "test findById not found"() {
        given:
        def customerReadOnlyQueryFacade = Mock(CustomerReadOnlyQueryFacade) {
            findById(1) >> Optional.empty()
        }

        when:
        new CustomerService(customerReadOnlyQueryFacade, Mock(CustomerRepository)).findById(1)
        
        then:
        thrown(EntityNotFoundException)
    }
}
