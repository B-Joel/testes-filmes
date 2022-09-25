package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidoAnoException extends ResponseStatusException {
    public InvalidoAnoException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
