package com.SpringBootAnnotations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringBootAnnotations.infra.repositories.UserRepository;

@Service
public class AuthorizarionService implements UserDetailsService {

  @Autowired
  @Qualifier("userRepository")
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    return this.userRepository.findByEmail(email);
  }

}
