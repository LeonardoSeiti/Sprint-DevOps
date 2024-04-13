package com.emi.sprint1java.controller;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    ;
}
