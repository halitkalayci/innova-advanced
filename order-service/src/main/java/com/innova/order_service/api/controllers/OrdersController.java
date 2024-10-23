package com.innova.order_service.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
  @GetMapping
  public String get() throws Exception {
    System.out.println("İstek geldi, işleniyor..");
    Thread.sleep(3000);
    return "Order service working..";
  }
}
