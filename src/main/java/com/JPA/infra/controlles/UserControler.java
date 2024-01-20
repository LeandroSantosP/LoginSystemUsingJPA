package com.JPA.infra.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JPA.application.CreateUser;
import com.JPA.application.CreateUser.PersisteInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    public CreateUser createUser;

    public record GetUserResponse(String name, int age, double salary) {
    }

    public record CreateUserInput(String name, int age, String login, double salary) {
    }

    @PostMapping("/")
    public String createUser(@RequestBody CreateUserInput entity) {
        return createUser.persiste(new PersisteInput(entity.name(), entity.age(), entity.login(), entity.salary()));
    }

    @GetMapping("/{id}")
    public GetUserResponse getUser(@PathVariable long id) {
        var output = createUser.get(id);
        return new GetUserResponse(output.name(), output.age(), output.salary());
    }
}
