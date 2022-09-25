package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidoNomeException extends ResponseStatusException {
    public InvalidoNomeException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED,reason);
    }
}
