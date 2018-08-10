package com.example.springdatagetone.infrastructure.exception.json;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-07-25.
 */
@Value
@Builder
public class ApplicationExceptionAsJSON {
    private String url;
    private String message;
}
