package com.SpringBootAnnotations;

public interface UserRepository {
    public record User(String id, String name, int age) {
    }

    public String pesiste(String name, int age);

    public User get(String id);
}
