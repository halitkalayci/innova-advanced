package com.innova.order_service.clients;

import io.github.halitkalayci.dtos.customer.responses.GetAllIndividualCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Customer Service ile sync iletişimi sağlayacak arayüz
@FeignClient(name = "customer-service")
public interface CustomerServiceClient
{
  @GetMapping("api/v1/individualcustomers")
  List<GetAllIndividualCustomerResponse> getAllIndiviualCustomers();
}
