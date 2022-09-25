package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidoGeneroException extends ResponseStatusException {
    public InvalidoGeneroException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
