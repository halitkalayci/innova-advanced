package com.innova.order_service.api.controllers;

import io.github.halitkalayci.ExampleService;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
  @GetMapping
  public String get(){
    ExampleService exampleService = new ExampleService();
    return exampleService.hello();
  }
}
