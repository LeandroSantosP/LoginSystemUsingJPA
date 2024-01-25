package com.SpringBootAnnotations.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAnnotations.application.CreateUserInput;
import com.SpringBootAnnotations.application.GetUserOutput;
import com.SpringBootAnnotations.application.LoginInput;
import com.SpringBootAnnotations.application.UserService;
import com.SpringBootAnnotations.infra.repositories.UserRepository;
import com.SpringBootAnnotations.infra.springBeans.LazyBean;
import com.SpringBootAnnotations.infra.springBeans.Logger;
import com.SpringBootAnnotations.infra.springBeans.MyBean;

import jakarta.validation.Valid;

@RestController
// @Scope("singleton") /* <-- nice one */
public class MyController {

    @Autowired
    private Logger logger;

    @Autowired
    private MyBean myBean;

    @Autowired
    private LazyBean lazyBean;

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Value("${app.portTest}")
    private String postgresPort;

    public MyController() {
        System.out.println("CONTROLLER");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid CreateUserInput body) {
        logger.currentTime();
        var output = this.userService.create(body);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GetUserOutput> get(@PathVariable String id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> postMethodName(@RequestBody @Valid LoginInput input) {
        this.userService.login(input);
        return ResponseEntity.ok().build();
    }

}
