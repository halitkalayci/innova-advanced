package com.innova.customer_service.business.dtos.responses;

import com.innova.customer_service.entities.IndividualCustomer;

public record GetAllIndividualCustomerResponse(String id, String firstName, String lastName) {
    public GetAllIndividualCustomerResponse(IndividualCustomer individualCustomer) {
        this(individualCustomer.getId(), individualCustomer.getFirstName(), individualCustomer.getLastName());
    }
}