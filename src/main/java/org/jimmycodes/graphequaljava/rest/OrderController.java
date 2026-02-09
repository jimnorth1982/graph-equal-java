package org.jimmycodes.graphequaljava.rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

  private static final Logger LOG = Logger.getLogger(OrderController.class.getName());

  private final List<OrderModel> orders = List.of(
    new OrderModel("1", "1", "Snacky Cakes", BigDecimal.valueOf(5.99)),
    new OrderModel("2", "1", "12pk Diet Coke", BigDecimal.valueOf(12.99)),
    new OrderModel("3", "1", "Doritos Family Size", BigDecimal.valueOf(6.99)),
    new OrderModel("1", "2", "Snacky Cakes", BigDecimal.valueOf(5.99)),
    new OrderModel("5", "2", "12pk Diet Coke", BigDecimal.valueOf(12.99)),
    new OrderModel("4", "2", "Choco Tacos", BigDecimal.valueOf(2.99)),
    new OrderModel("1", "3", "Snacky Cakes", BigDecimal.valueOf(5.99)),
    new OrderModel("5", "3", "12pk Diet Coke", BigDecimal.valueOf(12.99))
  );

  @GetMapping("/orders/{userId}")
  public List<OrderModel> getOrders(@PathVariable String userId) {
    LOG.info("REST request to get Orders by user " + userId);
    return orders.stream().filter((order) -> userId.equals(order.user_id())).toList();
  }

  @GetMapping("/order/{id}")
  public OrderModel getOrder(@PathVariable String id) {
    LOG.info("REST request to get Order " + id);
    return orders.stream().filter((order) -> id.equals(order.id())).findFirst().orElseThrow();
  }
}
