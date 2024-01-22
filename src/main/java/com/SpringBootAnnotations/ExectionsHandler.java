package com.SpringBootAnnotations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExectionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyNotFound.class)
    private ResponseEntity<String> handlerMyNotFound(MyNotFound ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
