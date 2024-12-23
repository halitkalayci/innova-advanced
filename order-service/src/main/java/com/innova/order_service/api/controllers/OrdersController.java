package com.innova.order_service.api.controllers;

import com.innova.order_service.clients.CustomerServiceClient;
import io.github.halitkalayci.dtos.customer.responses.GetAllIndividualCustomerResponse;
import io.github.halitkalayci.events.order.OrderCreatedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
  private final CustomerServiceClient customerServiceClient;
  private final KafkaTemplate<String, Object> kafkaTemplate;
  @GetMapping
  public String get(){
    List<GetAllIndividualCustomerResponse> customers = customerServiceClient.getAllIndiviualCustomers();
    //throw new RuntimeException("Order oluşturulamadı.");

    // Event fırlatacak
    kafkaTemplate.send("orderTopic", "orderCreated",new OrderCreatedEvent(
            UUID.randomUUID(), new Date(), 3000f
    ));
    return "Merhaba";
  }
}
