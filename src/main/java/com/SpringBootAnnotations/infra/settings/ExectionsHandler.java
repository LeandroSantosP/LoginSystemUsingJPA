package com.SpringBootAnnotations.infra.settings;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SpringBootAnnotations.domain.exeptions.MyNotFound;

@ControllerAdvice
public class ExectionsHandler extends ResponseEntityExceptionHandler {

    private record ErrorFormat(String type, HttpStatus erroCode, String message) {

    }

    @ExceptionHandler(MyNotFound.class)
    private ResponseEntity<ErrorFormat> handlerMyNotFound(MyNotFound ex) {
        ErrorFormat errorFormat = new ErrorFormat(ex.getType(), ex.getStatus(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorFormat);
    }
}
