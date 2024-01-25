package com.SpringBootAnnotations.domain;

public enum Roles {
  ADMIN("admin"),
  USER("user");

  private final String value;

  public String getValue() {
    return value;
  }

  Roles(String value) {
    this.value = value;
  }
}
