package org.jimmycodes.graphequaljava.order;

import com.netflix.graphql.dgs.*;
import org.jimmycodes.graphequaljava.codegen.types.Order;
import org.jimmycodes.graphequaljava.codegen.types.User;
import org.jspecify.annotations.NonNull;

import java.util.List;

@DgsComponent
public class OrderDatafetcher {
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
		return orderRepository.ordersByUserId(user.getId());
	}
}
