package com.SpringBootAnnotations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAnnotations.UserRepository.User;

@RestController
public class MyController {
    @Autowired
    private Logger logger;

    @Autowired
    @Qualifier("userRepositoryMemory")
    private UserRepository userRepository;

    private UUID id = UUID.randomUUID();

    @GetMapping("/create")
    public void create() {
        logger.currentTime();
        userRepository.pesiste(id, "John Doe", 12);
    }

    private record ResponseUser(UUID id, String name, int age) {
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseUser> get() {
        logger.currentTime();
        User user = userRepository.get(id);
        return ResponseEntity.ok(new ResponseUser(user.id(), user.name(), user.age()));
    }
}
