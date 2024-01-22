package com.SpringBootAnnotations;

import java.util.Hashtable;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryMemory implements UserRepository {

    private Hashtable<UUID, User> users;

    public UserRepositoryMemory() {
        this.users = new Hashtable<>();
    }

    @Override
    public void pesiste(UUID Id, String name, int age) {
        User user = new User(Id, name, age);
        this.users.put(user.id(), user);
    }

    @Override
    public User get(UUID id) {
        var s = this.users.get(id);
        if (s == null) {
            throw new MyNotFound();
        }
        return this.users.get(id);
    }

}
