package com.simplilearn.sportyshoes.controller;

import com.simplilearn.sportyshoes.service.AuthService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.LoginException;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleNoObjectWithId() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Message", "No product with that id exists"));
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> handleAuthException() {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(Map.of("Message", "Username / password incorrect or not an admin"));
    }
}
