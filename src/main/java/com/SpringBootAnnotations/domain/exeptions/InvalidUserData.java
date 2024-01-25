package com.SpringBootAnnotations.domain.exeptions;

import org.springframework.http.HttpStatus;

public class InvalidUserData extends RuntimeException {

    private String type = "default";

    public String getType() {
        return type;
    }

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public HttpStatus getStatus() {
        return status;
    }

    public InvalidUserData() {
        super("Invalid User Data!");
    }
}
