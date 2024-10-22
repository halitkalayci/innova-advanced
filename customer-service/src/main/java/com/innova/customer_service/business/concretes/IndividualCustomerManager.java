package com.innova.customer_service.business.concretes;

import com.innova.customer_service.business.abstracts.IndividualCustomerService;
import com.innova.customer_service.business.common.mapping.ModelMapperService;
import com.innova.customer_service.business.dtos.requests.CreateIndividualCustomerRequest;
import com.innova.customer_service.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.innova.customer_service.business.dtos.responses.GetAllIndividualCustomerResponse;
import com.innova.customer_service.business.rules.IndividualCustomerRules;
import com.innova.customer_service.entities.IndividualCustomer;
import com.innova.customer_service.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    private IndividualCustomerRules individualCustomerRules;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

        individualCustomerRules.customerFirstNameCanNotBeDuplicated(createIndividualCustomerRequest.getFirstName());

        IndividualCustomer customerToAdd = modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        customerToAdd.setId(UUID.randomUUID().toString());

        IndividualCustomer createdCustomer = individualCustomerRepository.save(customerToAdd);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse
                = new CreatedIndividualCustomerResponse(createdCustomer);



        return createdIndividualCustomerResponse;
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        var result = individualCustomerRepository.findAll();

        List<GetAllIndividualCustomerResponse> response
                = result.stream().map(customer->new GetAllIndividualCustomerResponse(customer)).collect(Collectors.toList());

        return response;
    }
}
