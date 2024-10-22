package com.innova.customer_service.business.concretes;

import com.innova.customer_service.business.abstracts.IndividualCustomerService;
import com.innova.customer_service.business.common.mapping.ModelMapperService;
import com.innova.customer_service.business.dtos.requests.CreateIndividualCustomerRequest;
import com.innova.customer_service.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.innova.customer_service.entities.IndividualCustomer;
import com.innova.customer_service.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

        IndividualCustomer customerToAdd = modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        customerToAdd.setId(UUID.randomUUID().toString());

        IndividualCustomer createdCustomer = individualCustomerRepository.save(customerToAdd);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse
                = new CreatedIndividualCustomerResponse(createdCustomer);



        return createdIndividualCustomerResponse;
    }
}
