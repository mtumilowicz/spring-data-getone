package com.example.springdatagetone.app.rest.controller.assembler

import com.example.springdatagetone.app.rest.controller.dto.CustomerDto
import com.example.springdatagetone.domain.model.Customer
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-10.
 */
class CustomerAssemblerTest extends Specification {
    def "test toEntity"() {
        given:
        def customerDto = CustomerDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        def expectedCustomer = Customer.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        when:
        def customer = CustomerAssembler.toEntity(customerDto)

        then:
        expectedCustomer == customer

        where:
        _id | _firstName
        1   | "firstName"
        1   | null
    }
}
