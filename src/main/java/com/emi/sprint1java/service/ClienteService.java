package com.emi.sprint1java.service;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente getCliente(int id) {
        return repository.findById(id);
    }

    public Cliente setCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente deleteCliente(int id) {
        Cliente cliente = repository.findById(id);
        repository.delete(cliente);
        return cliente;
        
    }
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
}