package com.innova.customer_service.business.abstracts;

import com.innova.customer_service.business.dtos.requests.CreateIndividualCustomerRequest;
import com.innova.customer_service.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.innova.customer_service.entities.IndividualCustomer;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
}

//response-request