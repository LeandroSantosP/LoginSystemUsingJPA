package com.SpringBootAnnotations.infra.repositories;

import java.util.ArrayList;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.SpringBootAnnotations.domain.User;
import com.SpringBootAnnotations.infra.exeptions.UserNotFound;

@Repository
public class UserRepositoryMemoryWithArray {

    private ArrayList<User> users;

    public UserRepositoryMemoryWithArray() {
        this.users = new ArrayList<>();
    }

    public String pesiste(User user) {
        user.getId();
        // HUser DataUser = new HUser(user.getName(), user.getAge(), user.getEmail(),
        // user.getPassword());
        this.users.add(user);
        return user.getId();
    }

    public User myGet(String id) {
        System.out.println("Repo with ArrayList");
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(UserNotFound::new);
    }

}
