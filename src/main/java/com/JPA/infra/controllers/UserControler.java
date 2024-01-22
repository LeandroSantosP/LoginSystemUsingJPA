package com.JPA.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JPA.application.CreateUser;
import com.JPA.application.CreateUser.GetUserOutput;
import com.JPA.application.CreateUser.PersisteInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    public CreateUser createUser;

    public record CreateUserInput(String name, int age, String login, double salary) {
    }

    @PostMapping("/")
    public String createUser(@RequestBody CreateUserInput entity) {
        return this.createUser
                .persiste(new PersisteInput(entity.name(), entity.age(), entity.login(), entity.salary()));
    }

    @GetMapping("/{id}")
    public GetUserOutput getUser(@PathVariable long id) {
        var output = this.createUser.get(id);
        return new GetUserOutput(output.name(), output.age(), output.login(), output.salary());
    }
}
