package com.innova.customer_service.business.dtos.responses;

import com.innova.customer_service.entities.IndividualCustomer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CreatedIndividualCustomerResponse(String id,String firstName,String lastName) {
    public CreatedIndividualCustomerResponse(IndividualCustomer individualCustomer) {
        this(individualCustomer.getId(), individualCustomer.getFirstName(), individualCustomer.getLastName());
    }
}


