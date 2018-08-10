package com.example.springdatagetone.app.rest.controller.assembler;

import com.example.springdatagetone.app.rest.controller.dto.CustomerDto;
import com.example.springdatagetone.domain.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerAssembler {
    static ModelMapper mapper = new ModelMapper();
    
    public static Customer toEntity(@NonNull CustomerDto dto) {
        return mapper.map(dto, Customer.class);
    }
}
