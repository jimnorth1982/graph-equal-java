package org.jimmycodes.graphequaljava.rest;

public class SearchFilter {

  public String email;
  public String firstName;
  public String lastName;
  public String id;

  @Override
  public String toString() {
    return "SearchFilter{" +
      "email='" + email + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", id='" + id + '\'' +
      '}';
  }
}
