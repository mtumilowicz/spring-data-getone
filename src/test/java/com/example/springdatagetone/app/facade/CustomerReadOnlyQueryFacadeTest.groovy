package com.example.springdatagetone.app.facade

import com.example.springdatagetone.infrastructure.repository.CustomerRepository
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-10.
 */
class CustomerReadOnlyQueryFacadeTest extends Specification {
    def "test getOne"() {
        given:
        def customerRepository = Mock(CustomerRepository)

        when:
        new CustomerReadOnlyQueryFacade(customerRepository).getOne(1)

        then:
        1 * customerRepository.getOne(1)
    }

    def "test findAll"() {
        given:
        def customerRepository = Mock(CustomerRepository)

        when:
        new CustomerReadOnlyQueryFacade(customerRepository).findAll()

        then:
        1 * customerRepository.findAll()
    }
}
