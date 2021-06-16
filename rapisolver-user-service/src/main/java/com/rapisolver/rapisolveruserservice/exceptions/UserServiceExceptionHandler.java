package com.rapisolver.rapisolveruserservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class UserServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        return new ResponseEntity<>(UserServiceExceptionResponse.builder().
                message(exception.getMessage()).
                details(request.getDescription(false)).
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                timestamp(LocalDateTime.now()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Object> handleRoleNotFoundExceptions(RoleNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(UserServiceExceptionResponse.builder().
                message(exception.getMessage()).
                details(request.getDescription(false)).
                status(HttpStatus.NOT_FOUND).
                timestamp(LocalDateTime.now()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(UserServiceExceptionResponse.builder().
                message(exception.getMessage()).
                details(request.getDescription(false)).
                status(HttpStatus.NOT_FOUND).
                timestamp(LocalDateTime.now()).build(), HttpStatus.NOT_FOUND);
    }

}