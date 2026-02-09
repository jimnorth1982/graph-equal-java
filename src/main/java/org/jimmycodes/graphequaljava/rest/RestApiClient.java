package org.jimmycodes.graphequaljava.rest;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


@Service
public class RestApiClient {

  private final ClientConfig config;

  public RestApiClient(ClientConfig config) {
    this.config = config;
  }

  public List<UserModel> getUsers(String emailFilter) {
    SearchFilter filter = new SearchFilter();
    filter.email = emailFilter;
    return config.restClientBuilder().build()
      .post()
      .uri("/users")
      .accept(MediaType.APPLICATION_JSON)
      .body(filter)
      .retrieve()
      .body(new ParameterizedTypeReference<>() {});
  }

  public UserModel getUser(String id) {
    return config.restClientBuilder().build()
      .get()
      .uri("/user/{id}", id)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .body(UserModel.class);
  }

  public List<OrderModel> getOrders(String userId) {
    return config.restClientBuilder().build()
      .get()
      .uri("/orders/{userId}", userId)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .body(new ParameterizedTypeReference<>() {});
  }

  public OrderModel getOrder(String orderId) {
    return config.restClientBuilder().build()
      .get()
      .uri("/order/{orderId}", orderId)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .body(OrderModel.class);
  }
}
