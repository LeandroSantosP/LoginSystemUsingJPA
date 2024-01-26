package com.SpringBootAnnotations.infra.repositories;

import java.util.Hashtable;
import org.springframework.stereotype.Repository;
import com.SpringBootAnnotations.domain.User;
import com.SpringBootAnnotations.infra.exeptions.UserNotFound;

@Repository
public class UserRepositoryMemory {

    private Hashtable<String, User> users;

    public UserRepositoryMemory() {
        this.users = new Hashtable<>();
    }

    public String pesiste(User user) {
        this.users.put(user.getId(), user);
        return user.getId();
    }

    public User myGet(String id) {
        User user = this.users.get(id);
        if (user == null) {
            throw new UserNotFound();
        }
        return user;
    }
}
