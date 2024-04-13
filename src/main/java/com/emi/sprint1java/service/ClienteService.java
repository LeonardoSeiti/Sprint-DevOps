package com.emi.sprint1java.service;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.dao.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente getCliente(int id) {
        System.out.println(id);
        return repository.findById(id);
    }
}