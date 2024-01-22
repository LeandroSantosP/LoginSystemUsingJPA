package com.JPA.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.infra.database.User;
import com.JPA.infra.database.UserRepository;

@Service
public class CreateUser {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EmailService emailService;

    public record GetUserOutput(String name, int age, String login, double salary) {
    }

    public record PersisteInput(String name, int age, String login, double salary) {
    }

    public String persiste(PersisteInput input) {
        long id = repository.save(input.name(), input.age(), input.login(), input.salary());
        this.emailService.sendEmail(input.name(), "SingUp", "Account Create With Success");
        return "" + id;
    }

    public GetUserOutput get(long id) {
        Optional<User> userG = repository.findById(id);
        if (!userG.isPresent()) {
            return null;
        }
        User user = userG.get();
        return new GetUserOutput(user.getName(), user.getAge(), user.getLogin(), user.getSalary());
    }

}
