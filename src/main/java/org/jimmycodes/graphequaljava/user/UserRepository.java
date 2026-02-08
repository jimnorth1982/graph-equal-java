package org.jimmycodes.graphequaljava.user;

import org.jimmycodes.graphequaljava.codegen.types.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {
	private final List<User> users = List.of(
			User.newBuilder().id("1").firstName("Jimmy").lastName("Joseph").email("jimmygoboom@mailinator.com").build(),
			User.newBuilder().id("2").firstName("Karl").lastName("Bratanalanalewski").email("karlBratanalanalewski@mailinator.com").build(),
			User.newBuilder().id("3").firstName("Master").lastName("Shake").email("mastershake@mailinator.com").build()
	);

	public List<User> users(String emailFilter) {
		if (emailFilter == null) {
			return this.users;
		}
		return this.users.stream().filter((user) -> user.getEmail().contains(emailFilter)).toList();
	}

	public User user(String id) {
		return this.users.stream().filter((user) -> user.getId().equals(id)).findFirst().orElse(null);
	}
}
