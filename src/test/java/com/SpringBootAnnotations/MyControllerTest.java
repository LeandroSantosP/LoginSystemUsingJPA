package com.SpringBootAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import com.AuthLogin.application.CreateUserInput;
import com.AuthLogin.application.GetUserOutput;

import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class MyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    void testCreateUser() {

        var input = new CreateUserInput("Jonh Doe", 33, "john.doe@gmail.com", "senha123");
        String id = this.template.postForEntity("http://localhost:" + port + "/create", input,
                String.class).getBody();

        GetUserOutput output = this.template.getForEntity("http://localhost:" + port
                + "/get/" + id,
                GetUserOutput.class).getBody();

        // assertEquals(output.name(), "Jonh Doe");
        // assertEquals(output.age(), 33);
    }

}
