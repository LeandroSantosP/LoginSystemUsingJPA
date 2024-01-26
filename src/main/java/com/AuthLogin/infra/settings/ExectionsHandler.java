package com.AuthLogin.infra.settings;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.AuthLogin.infra.exeptions.InvalidUserData;
import com.AuthLogin.infra.exeptions.UserNotFound;

@ControllerAdvice
public class ExectionsHandler extends ResponseEntityExceptionHandler {

    private record ErrorFormat(String type, HttpStatus erroCode, String message) {

    }

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<ErrorFormat> handlerMyNotFound(UserNotFound ex) {
        ErrorFormat errorFormat = new ErrorFormat(ex.getType(), ex.getStatus(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorFormat);
    }

    @ExceptionHandler(InvalidUserData.class)
    private ResponseEntity<ErrorFormat> handlerInvalidUserData(InvalidUserData ex) {
        ErrorFormat errorFormat = new ErrorFormat(ex.getType(), ex.getStatus(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorFormat);
    }
}
