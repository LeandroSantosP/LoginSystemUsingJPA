package com.SpringBootAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.SpringBootAnnotations.MyController.CreateUserInput;
import com.SpringBootAnnotations.MyController.ResponseUser;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    void testCreateUser() {
        var input = new CreateUserInput("Jonh Doe", 33);
        String id = this.template.postForEntity("http://localhost:" + port + "/create", input,
                String.class).getBody();

        ResponseUser output = this.template.getForEntity("http://localhost:" + port + "/get/" + id,
                ResponseUser.class).getBody();

        assertEquals(output.name(), "Jonh Doe");
        assertEquals(output.age(), 33);
    }

}
