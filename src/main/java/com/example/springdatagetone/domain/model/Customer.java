package com.example.springdatagetone.domain.model;

import com.google.common.base.Preconditions;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Objects;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    Integer id;
    String firstName;
    
    public void updateFrom(@NonNull Customer customer) {
        Preconditions.checkArgument(Objects.equals(id, customer.id));
        
        if (nonNull(customer.getFirstName())) {
            firstName = customer.getFirstName();
        }
    }
}
