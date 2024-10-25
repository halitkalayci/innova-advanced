package io.github.halitkalayci.events.order;

import java.util.Date;
import java.util.UUID;

public class OrderCreatedEvent
{
  private UUID orderId;
  private Date orderDate;
  private float totalPrice;

  public OrderCreatedEvent() {
  }

  public OrderCreatedEvent(UUID orderId, Date orderDate, float totalPrice) {
    this.orderId = orderId;
    this.orderDate = orderDate;
    this.totalPrice = totalPrice;
  }

  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(float totalPrice) {
    this.totalPrice = totalPrice;
  }
}
