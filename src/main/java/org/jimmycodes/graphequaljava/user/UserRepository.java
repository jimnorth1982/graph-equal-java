package org.jimmycodes.graphequaljava.user;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import graphql.GraphQLException;
import org.jimmycodes.graphequaljava.codegen.types.User;
import org.jimmycodes.graphequaljava.rest.RestApiClient;
import org.jimmycodes.graphequaljava.rest.UserModel;
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
    return restApiClient.getUsers(emailFilter).stream().map((userModel -> new User(userModel.user_id(), userModel.email_address(), userModel.first_name(), userModel.last_name(), new ArrayList<>()))).toList();
  }

  public User user(String id) {
    UserModel userModel = restApiClient.getUser(id);
    if (userModel == null) {
      throw new GraphQLException("User with id " + id + " does not exist");
    }
    return new User(userModel.user_id(), userModel.email_address(), userModel.first_name(), userModel.last_name(), new ArrayList<>());
  }
}
