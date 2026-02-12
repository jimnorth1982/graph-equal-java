package org.jimmycodes.graphequaljava.rest;


import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class OrderControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private RestTestClient restTestClient;

  @Test
  void getOrder() throws Exception {
    restTestClient.get()
      .uri("http://localhost:%d/order/{id}".formatted(port), "1")
      .exchange()
      .expectBody(Object.class)
      .isEqualTo(new OrderModel("1", "1", "Snacky Cakes", BigDecimal.valueOf(5.99)));
  }
}