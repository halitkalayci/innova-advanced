package com.innova.customer_service.api.controllers;

import com.innova.customer_service.business.abstracts.IndividualCustomerService;
import com.innova.customer_service.business.dtos.requests.CreateIndividualCustomerRequest;
import com.innova.customer_service.business.dtos.responses.CreatedIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/individualcustomers")
public class IndividualCustomersConstoller {
    private IndividualCustomerService individualCustomerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
        return individualCustomerService.add(createIndividualCustomerRequest);
    }
}
