package com.SpringBootAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("singleton") /* <-- nice one */
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

    @Value("${app.portTest}")
    private String postgresPort;

    public MyController() {
        System.out.println("CONTROLLER");
    }

    public record CreateUserInput(String name, int age, String email, String password) {
    }

    @PostMapping("/create")
    public String create(@RequestBody CreateUserInput body) {
        logger.currentTime();
        User user = new User(body.name(), body.age(), body.email(), body.password());
        return userRepository.pesiste(user);
    }

    public record ResponseUser(String id, String name, int age) {
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseUser> get(@PathVariable String id) {
        this.myBean.exec();
        logger.currentTime();
        User user = userRepository.myGet(id);
        return ResponseEntity.ok(new ResponseUser(user.getId(), user.getName(), user.getAge()));
    }

}
