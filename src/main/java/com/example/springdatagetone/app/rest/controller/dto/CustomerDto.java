package com.example.springdatagetone.app.rest.controller.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Value
@Builder
public class CustomerDto {
    long id;
    String firstName;
}
