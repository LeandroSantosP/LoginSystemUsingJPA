package com.SpringBootAnnotations;

public enum Roles {
  DEFAULT("commun"), ADMIN("admin");

  private final String value;

  public String getValue() {
    return value;
  }

  Roles(String value) {
    this.value = value;
  }
}
