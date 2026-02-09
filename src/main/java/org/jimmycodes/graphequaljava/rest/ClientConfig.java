package org.jimmycodes.graphequaljava.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
public class ClientConfig {

  private static final Logger LOG = Logger.getLogger(ClientConfig.class.getName());

  @Value("${BASE_URL}")
  private String baseUrl;

  @Bean
  public RestClient.Builder restClientBuilder() {
    LOG.info("restClientBuilder called");
    LOG.info("baseUrl: " + baseUrl);
    return RestClient.builder()
      .baseUrl(baseUrl)
      .defaultHeader("Accept", "application/json");
  }
}