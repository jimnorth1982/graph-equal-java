package org.jimmycodes.graphequaljava.user;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import graphql.GraphQLException;
import org.jimmycodes.graphequaljava.codegen.types.User;
import org.jimmycodes.graphequaljava.rest.RestApiClient;
import org.jimmycodes.graphequaljava.rest.UserModel;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;


@Component
public class UserRepository {

  private static final Logger logger = Logger.getLogger(UserRepository.class.getName());

  private final RestApiClient restApiClient;

  public UserRepository(RestApiClient restApiClient) {
    this.restApiClient = restApiClient;
  }

  public List<User> users(String emailFilter) {
    logger.info("UserRepository.users called");
    return restApiClient.getUsers(emailFilter).stream().map(UserRepository::mapUser).toList();
  }

  public User user(String id) {
    UserModel userModel = restApiClient.getUser(id);
    if (userModel == null) {
      throw new GraphQLException("User with id " + id + " does not exist");
    }
    return mapUser(userModel);
  }

  private static @NonNull User mapUser(UserModel userModel) {
    return User.newBuilder()
      .id(userModel.user_id())
      .email(userModel.email_address())
      .firstName(userModel.first_name())
      .lastName(userModel.last_name())
      .build();
  }
}
