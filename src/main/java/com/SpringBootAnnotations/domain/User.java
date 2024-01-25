package com.SpringBootAnnotations.domain;

import edu.umd.cs.findbugs.annotations.NonNull;
import lombok.Getter;

@Getter
public class User {
  private String id;

  private @NonNull String name;

  private @NonNull int age;

  private @NonNull String email;

  private @NonNull Roles roles;

  private @NonNull String password;

  public User(String name, int age, String email, String password) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.password = password;
    this.roles = Roles.DEFAULT;
  }

  private void encrypPassword() {
  }

}
