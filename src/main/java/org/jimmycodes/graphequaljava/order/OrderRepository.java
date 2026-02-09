package org.jimmycodes.graphequaljava.order;

import java.util.List;
import java.util.logging.Logger;

import org.jimmycodes.graphequaljava.codegen.types.Order;
import org.jimmycodes.graphequaljava.rest.OrderModel;
import org.jimmycodes.graphequaljava.rest.RestApiClient;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;


@Component
public class OrderRepository {

  private static final Logger LOG = Logger.getLogger(OrderRepository.class.getName());

  private final RestApiClient restApiClient;

  public OrderRepository(RestApiClient restApiClient) {this.restApiClient = restApiClient;}


  public List<Order> ordersByUserId(String userId) {
    LOG.info("REST request to get Orders by userId " + userId);
    return restApiClient.getOrders(userId).stream()
      .map(OrderRepository::mapOrder)
      .toList();
  }

  public Order order(String orderId) {
    LOG.info("REST request to get Order " + orderId);
    return mapOrder(restApiClient.getOrder(orderId));
  }

  private static @NonNull Order mapOrder(OrderModel model) {
    return Order.newBuilder()
      .id(model.id())
      .userId(model.user_id())
      .product(model.name())
      .build();
  }
}
