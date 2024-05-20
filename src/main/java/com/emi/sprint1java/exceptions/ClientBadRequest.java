package com.emi.sprint1java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientBadRequest extends RuntimeException {
    public ClientBadRequest(int id) {
        super("Conta não encontrada");
    }
}
