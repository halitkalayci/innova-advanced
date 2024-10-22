package com.innova.customer_service.repositories.abstracts;

import com.innova.customer_service.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,String> {
     Optional<IndividualCustomer> findByFirstNameIgnoreCase(String firstName);
}

//IndividualCustomerRepositoryImpl