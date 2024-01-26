package com.AuthLogin.domain;

public enum Roles {
  ADMIN("ADMIN"),
  USER("USER");

  private final String value;

  public String getValue() {
    return value;
  }

  Roles(String value) {
    this.value = value;
  }
}
