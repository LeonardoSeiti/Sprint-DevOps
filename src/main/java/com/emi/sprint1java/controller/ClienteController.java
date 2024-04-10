package com.emi.sprint1java.controller;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
    }
}
