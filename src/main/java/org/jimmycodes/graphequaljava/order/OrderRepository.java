package org.jimmycodes.graphequaljava.order;

import org.jimmycodes.graphequaljava.codegen.types.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository {
	private final List<Order> orders = List.of(
			Order.newBuilder().id("1").userId("1").product("Yummy Snacks").build(),
			Order.newBuilder().id("2").userId("1").product("Refreshing Water").build(),
			Order.newBuilder().id("3").userId("1").product("Rotten Tomatoes").build(),
			Order.newBuilder().id("4").userId("1").product("Nasty Potatoes").build()
	);


	public List<Order> ordersByUserId(String userId) {
		if (userId == null) {
			return null;
		}
		return orders.stream().filter((order) -> userId.equals(order.getUserId())).toList();
	}

	public Order order(String orderId) {
		return orders.stream().filter((order) -> orderId.equals(order.getId())).findFirst().orElse(null);
	}
}
