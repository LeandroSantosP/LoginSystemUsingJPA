package com.SpringBootAnnotations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAnnotations.UserRepository.User;

@RestController
public class MyController {
    @Autowired
    private Logger logger;

    @Autowired
    @Qualifier("userRepositoryMemory")
    private UserRepository userRepository;

    public record CreateUserInput(String name, int age) {
    }

    @PostMapping("/create")
    public String create(@RequestBody CreateUserInput body) {
        logger.currentTime();
        return userRepository.pesiste(body.name(), body.age());
    }

    public record ResponseUser(String id, String name, int age) {
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseUser> get(@PathVariable String id) {
        System.out.println("___________LEO_" + id);
        logger.currentTime();
        User user = userRepository.get(id);
        return ResponseEntity.ok(new ResponseUser(user.id(), user.name(), user.age()));
    }
}
