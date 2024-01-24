package com.SpringBootAnnotations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

public interface UserRepository extends JpaRepository<HUser, String> {

    default public String pesiste(User user) {
        HUser userData = HUser.builder()
                .name(user.getName()).age(user.getAge()).roles(user.getRoles())
                .email(user.getEmail()).password(user.getPassword()).build();
        this.save(userData);
        return user.getId();
    };

    default public User myGet(String id) {
        Optional<HUser> userDataOptional = this.findById(id);
        if (!userDataOptional.isPresent()) {
            throw new MyNotFound();
        }
        HUser userData = userDataOptional.get();
        return new User(userData.getName(), userData.getAge(), userData.getEmail(), userData.getPassword());
    };

    UserDetails findByName(String name);

}
