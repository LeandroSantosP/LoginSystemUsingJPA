package com.SpringBootAnnotations;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserRepositoryMemoryWithArray implements UserRepository {

    private ArrayList<User> users;

    public UserRepositoryMemoryWithArray() {
        this.users = new ArrayList<>();
    }

    @Override
    public String pesiste(String name, int age) {
        User user = new User(UUID.randomUUID().toString(), name, age);
        this.users.add(user);
        return user.id().toString();
    }

    @Override
    public User get(String id) {
        System.out.println("Repo with ArrayList");
        return this.users.stream().filter(user -> user.id().equals(id)).findFirst().orElseThrow(MyNotFound::new);
    }

}
