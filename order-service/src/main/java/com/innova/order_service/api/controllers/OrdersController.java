package com.innova.order_service.api.controllers;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
  @GetMapping
  public String get(){
    throw new RuntimeException("Order oluşturulamadı.");
    //return "Merhaba";
  }
}
