package org.jimmycodes.graphequaljava.order;

import java.util.List;
import java.util.logging.Logger;

import org.jimmycodes.graphequaljava.codegen.types.Order;
import org.jimmycodes.graphequaljava.rest.OrderModel;
import org.jimmycodes.graphequaljava.rest.RestApiClient;
import org.springframework.stereotype.Component;


@Component
public class OrderRepository {

  private static final Logger LOG = Logger.getLogger(OrderRepository.class.getName());

  private final RestApiClient restApiClient;

  public OrderRepository(RestApiClient restApiClient) {this.restApiClient = restApiClient;}


  public List<Order> ordersByUserId(String userId) {
    LOG.info("REST request to get Orders by userId " + userId);
    return restApiClient.getOrders(userId).stream()
      .map(model -> new Order(model.id(), model.user_id(), model.name()))
      .toList();
  }

  public Order order(String orderId) {
    LOG.info("REST request to get Order " + orderId);
    OrderModel model = restApiClient.getOrder(orderId);
    return new Order(model.id(), model.user_id(), model.name());
  }
}
