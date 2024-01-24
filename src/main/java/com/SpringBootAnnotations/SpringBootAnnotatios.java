package com.SpringBootAnnotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringBootAnnotatios {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAnnotatios.class, args);
    }
}
