package com.emi.sprint1java.service;

import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{

    @Autowired
    private ClienteDAO clienteDAO;

    public void salvar(Cliente cliente) {
        ClienteDAO.salvar(cliente);
    }
    public void editar(Cliente cliente) {
        ClienteDAO.editar(cliente);
    }

    public void deletar(Cliente cliente) {
        ClienteDAO.deletar(cliente);
    }
}