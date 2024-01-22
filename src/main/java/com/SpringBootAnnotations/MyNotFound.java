package com.SpringBootAnnotations;

import org.springframework.http.HttpStatus;

public class MyNotFound extends RuntimeException {

    private String type = "default";

    public String getType() {
        return type;
    }

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public HttpStatus getStatus() {
        return status;
    }

    public MyNotFound() {
        super("User Not Found!");
    }

    public MyNotFound(String message) {
        super(message);
    }
}
