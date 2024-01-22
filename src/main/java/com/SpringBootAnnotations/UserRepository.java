package com.SpringBootAnnotations;

import java.util.UUID;

public interface UserRepository {
    public record User(UUID id, String name, int age) {
    }

    public void pesiste(UUID Id, String name, int age);

    public User get(UUID id);
}
