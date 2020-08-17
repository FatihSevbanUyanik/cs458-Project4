package com.example.coronatracking.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExceptionAuth extends RuntimeException {
    public ExceptionAuth(String message) {
        super(message);
    }
}

