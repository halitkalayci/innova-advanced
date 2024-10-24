package com.innova.customer_service.business.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {

    @NotNull
    @Size(min = 2,max=30)
    private String firstName;

    @NotNull
    @Size(min = 2,max=30)
    private String lastName;
}
