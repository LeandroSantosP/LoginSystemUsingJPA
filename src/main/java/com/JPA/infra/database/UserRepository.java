package com.JPA.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default public long save(String name, int age, String login, double salary) {
        User user = new User(name, age, login, salary); /* And Here translate the Domain Entity to Jpa Entity */
        this.save(user);
        return user.getId();
    }
}