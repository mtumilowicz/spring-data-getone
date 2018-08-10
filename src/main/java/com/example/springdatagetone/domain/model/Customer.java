package com.example.springdatagetone.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    Long id;
    String firstName;
}
