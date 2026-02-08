package org.jimmycodes.graphequaljava.user;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.jimmycodes.graphequaljava.codegen.types.User;
import org.jimmycodes.graphequaljava.order.OrderRepository;

import java.util.List;

@DgsComponent
public class UserDatafetcher {
	private final UserRepository userRepository;

	public UserDatafetcher(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@DgsQuery
	public List<User> users(@InputArgument String emailFilter) {
		return userRepository.users(emailFilter);
	}

	@DgsQuery
	public User user(@InputArgument String id) {
		return userRepository.user(id);
	}
}
