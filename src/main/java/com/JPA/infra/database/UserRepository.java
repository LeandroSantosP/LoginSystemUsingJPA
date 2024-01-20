package com.JPA.infra.database;

public interface UserRepository {
    public long save(String name, int age, String login, double salary);
}