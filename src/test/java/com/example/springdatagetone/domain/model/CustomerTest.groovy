package com.example.springdatagetone.domain.model

import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-11.
 */
class CustomerTest extends Specification {
    def "test updateFrom when updateFrom customer has different id"() {
        given:
        def updateFrom = Customer.builder()
                .id(1)
                .build()

        def toUpdate = Customer.builder()
                .id(2)
                .build()

        when:
        toUpdate.updateFrom(updateFrom)

        then:
        thrown(IllegalArgumentException)
    }

    def "test updateFrom when updateFrom customer.firstName == null"() {
        given:
        def updateFrom = Customer.builder()
                .id(1)
                .build()

        def toUpdate = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        toUpdate.updateFrom(updateFrom)

        then:
        toUpdate.firstName == "firstName"
    }

    def "test updateFrom when updateFrom customer.firstName != null"() {
        given:
        def updateFrom = Customer.builder()
                .id(1)
                .firstName("changed")
                .build()

        def toUpdate = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        toUpdate.updateFrom(updateFrom)

        then:
        toUpdate.firstName == "changed"
    }
}
