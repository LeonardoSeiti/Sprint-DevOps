package com.emi.sprint1java.controller;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/{id}")
    public Cliente buscarId(@PathVariable int id) {
        return service.getCliente(id);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.setCliente(cliente);
    }
    
    @DeleteMapping("/{id}")
    public Cliente deletar(@PathVariable int id) {
        return service.deleteCliente(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(CREATED)
    public Cliente atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        return service.save(cliente);
    }
}
