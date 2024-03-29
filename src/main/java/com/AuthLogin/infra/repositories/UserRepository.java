package com.AuthLogin.infra.repositories;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.AuthLogin.domain.User;
import com.AuthLogin.infra.exeptions.UserNotFound;
import com.AuthLogin.infra.settings.HUser;

@Primary
public interface UserRepository extends JpaRepository<HUser, String> {

  default public String pesiste(User user) {
    HUser userData = HUser.builder()
        .name(user.getName()).age(user.getAge()).roles(user.getRoles())
        .email(user.getEmail()).password(user.getPassword()).roles(user.getRoles()).build();
    this.save(userData);

    return userData.getId();
  };

  default public User myGet(String id) {
    Optional<HUser> userDataOptional = this.findById(id);
    if (!userDataOptional.isPresent()) {
      throw new UserNotFound();
    }

    HUser userData = userDataOptional.get();
    return new User(userData.getId(), userData.getName(), userData.getAge(), userData.getEmail(),
        userData.getPassword(), userData.getRoles());
  };

  UserDetails findByEmail(String email);
}
