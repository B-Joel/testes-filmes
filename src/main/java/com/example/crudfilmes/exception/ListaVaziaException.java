package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ListaVaziaException extends ResponseStatusException {
    public ListaVaziaException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
