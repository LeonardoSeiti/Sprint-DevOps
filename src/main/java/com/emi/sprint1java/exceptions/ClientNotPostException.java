package com.emi.sprint1java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientNotPostException extends RuntimeException {
    public ClientNotPostException(int id) {
        super("Falta ou excesso de argumentos");
    }
}
