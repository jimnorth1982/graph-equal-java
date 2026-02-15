package org.jimmycodes.graphequaljava.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

  private static final Logger LOG = Logger.getLogger(UserController.class.getName());

  private final List<UserModel> users = List.of(
    new UserModel("1", "jimmygoboom@mailinator.com", "Jimmy", "Joseph"),
    new UserModel("2", "karlBratanalanalewski@mailinator.com", "Karl", "Bratanalanalewski"),
    new UserModel("3", "mastershake@mailinator.com", "Master", "Shake")
  );

  @GetMapping("/user/{id}")
  public UserModel user(@PathVariable String id) {
    LOG.info("REST request to get User by id " + id);
    return users.stream().filter((user) -> id.equals(user.user_id())).findFirst().orElseThrow(); // look @ ExceptionSupplier
  }

  @PostMapping("/users")
  public List<UserModel> users(@RequestBody SearchFilter filter) {
    LOG.info("REST request to get Users by filter " + filter);
    if (filter == null || filter.email == null) {
      return users;
    }
    return users.stream().filter((user) -> user.email_address().startsWith(filter.email)).toList();
  }
}
