package com.SpringBootAnnotations.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import lombok.Getter;

public class JwtManneger {
  private String jwtSecret;

  @Getter
  private String issuerName = "auth-api";

  private final Instant expiredTime;

  public JwtManneger(Instant expiredTime, String secret) {
    this.jwtSecret = secret;
    this.expiredTime = expiredTime;
  }

  public JwtManneger(String secret) {
    this.jwtSecret = secret;
    this.expiredTime = this.generationExpiretedTime();
  }

  public String generateToken(String email) {
    try {
      return JWT.create().withIssuer(issuerName).withSubject(email)
          .withExpiresAt(this.expiredTime).sign(Algorithm.HMAC256(jwtSecret));
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro while generate jwt token", e);
    }
  }

  public String validateToken(String tokenForValidation) {
    try {
      return JWT.require(Algorithm.HMAC256(jwtSecret)).withIssuer(issuerName).build().verify(tokenForValidation)
          .getSubject();
    } catch (JWTVerificationException e) {
      System.out.println("INVALID JWT: " + e.getMessage());
      return "";
    }
  }

  private Instant generationExpiretedTime() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

}
