package com.example.springdatagetone.app.rest.controller


import com.example.springdatagetone.app.rest.controller.CustomerController
import com.example.springdatagetone.app.rest.controller.dto.CustomerDto
import com.example.springdatagetone.domain.model.Customer
import com.example.springdatagetone.domain.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerControllerTest extends Specification {

    def service = Mock(CustomerService)
    def controller = new CustomerController(service)

    def "test update"() {
        given:
        def customerDto = CustomerDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        when:
        controller.update(customerDto)

        then:
        1 * service.update(Customer.builder()
                .id(_id)
                .firstName(_firstName)
                .build())

        where:
        _id | _firstName
        1   | "firstName"
    }

    def "test findById"() {
        when:
        controller.findById(1)

        then:
        1 * service.findById(1)
    }

    def "test findAll"() {
        when:
        controller.findAll()

        then:
        1 * service.findAll()
    }
}
