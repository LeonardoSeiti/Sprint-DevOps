package com.emi.sprint1java.controller;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/{id}")
    public Cliente buscarId(@PathVariable int id) {
        return service.getCliente(id);
    }
}
