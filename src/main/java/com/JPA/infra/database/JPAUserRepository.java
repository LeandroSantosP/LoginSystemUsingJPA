package com.JPA.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAUserRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    default long save(String name, int age, String login, double salary)/* <-- moust eceive a Domain Entity */ {
        User user = new User(name, age, login, salary); /* And Here translate the Domain Entity and Jpa Entity */
        this.save(user);
        return user.getId();
    }
}