package com.AuthLogin.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    this.password = this.encryptPassword(password);
    this.roles = Roles.USER;
  }

  public User(String id, String name, int age, String email, String password, Roles roles) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

  private String encryptPassword(String pass) {
    return new BCryptPasswordEncoder().encode(pass);
  }
}
