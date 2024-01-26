package com.SpringBootAnnotations.infra.exeptions;

import org.springframework.http.HttpStatus;

public class UserNotFound extends RuntimeException {

    private String type = "default";

    public String getType() {
        return type;
    }

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public HttpStatus getStatus() {
        return status;
    }

    public UserNotFound() {
        super("User Not Found!");
    }

    public UserNotFound(String message) {
        super(message);
    }
}
