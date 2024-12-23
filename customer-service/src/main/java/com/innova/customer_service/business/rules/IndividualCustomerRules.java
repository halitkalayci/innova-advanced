package com.innova.customer_service.business.rules;

import com.innova.customer_service.entities.IndividualCustomer;
import com.innova.customer_service.repositories.abstracts.IndividualCustomerRepository;
import com.innova.customer_service.utils.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerRules {
    IndividualCustomerRepository individualCustomerRepository;

    public void  customerFirstNameCanNotBeDuplicated(String firstName){
        Optional<IndividualCustomer> result =  individualCustomerRepository.findByFirstNameIgnoreCase(firstName);
        if (result.isPresent()){
            throw new BusinessException("Customer's first name can not be duplicated.");
        }
    }
}
