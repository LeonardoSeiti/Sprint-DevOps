package com.emi.sprint1java.service;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{

    @Autowired
    private ClienteDAO clienteDAO;

    public Cliente salvar(Cliente cliente) {
        ClienteDAO.salvar(cliente);
        return cliente;
    }
    public Cliente editar(Cliente cliente) {
        ClienteDAO.editar(cliente);
        return cliente;
    }

    public Cliente deletar(Cliente cliente) {
        ClienteDAO.deletar(cliente.getId());
        return cliente;
    }
}