package com.innova.notificationservice;

import io.github.halitkalayci.events.order.OrderCreatedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApplication.class, args);
  }

  @KafkaListener(topics = {"orderTopic"}, groupId = "notificationGroup")
  public void handleOrderCreationEvent(OrderCreatedEvent event){
    System.out.println("Yeni sipariş yakalandı.. Email gönderiliyor..");
  }
}
