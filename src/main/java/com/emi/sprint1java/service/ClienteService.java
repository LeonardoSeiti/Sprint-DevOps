package com.emi.sprint1java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emi.sprint1java.cliente.Cliente;
import com.emi.sprint1java.cliente.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente getCliente(long id) {
        return repository.findById(id);
    }

    public Cliente setCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente deleteCliente(long id) {
        Cliente cliente = repository.findById(id);
        repository.delete(cliente);
        return cliente;
        
    }
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
}