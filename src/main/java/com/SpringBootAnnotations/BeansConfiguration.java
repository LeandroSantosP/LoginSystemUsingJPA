package com.SpringBootAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BeansConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public Logger logger() {
        return new Logger();
    }

    @Bean
    public LazyBean lazyBean() {
        return new LazyBean();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(cs -> cs.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auto -> auto.requestMatchers("/test")
                        .hasRole("admin").anyRequest().authenticated())
                .build();
    }
}
