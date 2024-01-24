package com.JPA.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default public long save(String name, int age, String login, double salary) {
        /*
         * And Her/* And Here
         * translate the Domain
         * Entity to Jpa Entity
         */
        User user = User.builder().name(name).age(age).login(login).salary(salary).build();
        this.save(user);
        return user.getId();
    }
}