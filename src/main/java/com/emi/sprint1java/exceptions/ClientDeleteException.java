package com.emi.sprint1java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientDeleteException extends RuntimeException {
    public ClientDeleteException(int id) {
        super("Conta não encontrada");
    }
}
