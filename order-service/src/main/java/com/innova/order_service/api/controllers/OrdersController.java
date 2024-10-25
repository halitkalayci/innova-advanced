package com.innova.order_service.api.controllers;

import com.innova.order_service.clients.CustomerServiceClient;
import io.github.halitkalayci.dtos.customer.responses.GetAllIndividualCustomerResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
  private final CustomerServiceClient customerServiceClient;
  @GetMapping
  public String get(){
    List<GetAllIndividualCustomerResponse> customers = customerServiceClient.getAllIndiviualCustomers();
    //throw new RuntimeException("Order oluşturulamadı.");
    return "Merhaba";
  }
}
