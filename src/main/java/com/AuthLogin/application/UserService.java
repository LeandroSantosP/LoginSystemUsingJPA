package com.AuthLogin.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.AuthLogin.domain.JwtManneger;
import com.AuthLogin.domain.User;
import com.AuthLogin.infra.exeptions.InvalidUserData;
import com.AuthLogin.infra.repositories.UserRepository;
import com.AuthLogin.infra.settings.HUser;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Value("${api.security.jwt_secret}")
  public String jwtSecret;

  public String create(CreateUserInput input) {
    if (this.userRepository.findByEmail(input.email()) != null) {
      throw new InvalidUserData();
    }
    User user = new User(input.name(), input.age(), input.email(), input.password());
    return this.userRepository.pesiste(user);
  }

  public String login(LoginInput input) {
    var credentials = new UsernamePasswordAuthenticationToken(input.email(), input.password());
    Authentication auth = this.authenticationManager.authenticate(credentials);
    HUser user = (HUser) auth.getPrincipal();
    JwtManneger jwtManeget = new JwtManneger(jwtSecret);
    return jwtManeget.generateToken(user.getEmail());
  }

  public GetUserOutput get(String id) {
    User user = userRepository.myGet(id);
    return new GetUserOutput(user.getId(), user.getEmail(), user.getName(), user.getAge());
  }

}
