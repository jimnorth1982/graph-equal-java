package org.jimmycodes.graphequaljava.order;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.jimmycodes.graphequaljava.codegen.types.Order;
import org.jimmycodes.graphequaljava.codegen.types.User;
import org.jspecify.annotations.NonNull;


@DgsComponent
public class OrderDatafetcher {
  private static final Logger LOG = Logger.getLogger(OrderDatafetcher.class.getName());
  private final OrderRepository orderRepository;

  public OrderDatafetcher(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @DgsQuery
  public List<Order> orders(@InputArgument String userId) {
    return orderRepository.ordersByUserId(userId);
  }

  @DgsQuery
  public Order order(@InputArgument String id) {
    return orderRepository.order(id);
  }

  @DgsData(parentType = "User")
  public List<Order> orders(@NonNull DgsDataFetchingEnvironment dfe) {
    User user = dfe.getSourceOrThrow();
    LOG.log(Level.INFO, "Getting orders for User: {0}", user);
    return orderRepository.ordersByUserId(user.getId());
  }
}
