package com.SpringBootAnnotations;

import java.util.Hashtable;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryMemory implements UserRepository {

    private Hashtable<String, User> users;

    public UserRepositoryMemory() {
        this.users = new Hashtable<>();
    }

    @Override
    public String pesiste(String name, int age) {
        User user = new User(UUID.randomUUID().toString(), name, age);
        this.users.put(user.id(), user);
        return user.id().toString();
    }

    @Override
    public User get(String id) {
        User user = this.users.get(id);

        if (user == null) {
            throw new MyNotFound();
        }
        return user;
    }

}
