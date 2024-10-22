package com.innova.customer_service.repositories.abstracts;

import com.innova.customer_service.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,String> {

}

//IndividualCustomerRepositoryImpl