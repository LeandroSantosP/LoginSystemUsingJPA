package com.SpringBootAnnotations.application;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.SpringBootAnnotations.domain.User;
import com.SpringBootAnnotations.domain.exeptions.InvalidUserData;
import com.SpringBootAnnotations.infra.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  @Qualifier("userRepository")
  private UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String create(CreateUserInput input) {
    if (this.userRepository.findByEmail(input.email()) != null) {
      throw new InvalidUserData();
    }
    User user = new User(input.name(), input.age(), input.email(), input.password());
    return this.userRepository.pesiste(user);
  }

  public void login(LoginInput input) {
    var user = new UsernamePasswordAuthenticationToken(input.email(), input.password());
    var auth = this.authenticationManager.authenticate(user);
  }

  public GetUserOutput get(String id) {
    User user = userRepository.myGet(id);
    return new GetUserOutput(user.getId(), user.getEmail(), user.getName(), user.getAge());
  }

}
