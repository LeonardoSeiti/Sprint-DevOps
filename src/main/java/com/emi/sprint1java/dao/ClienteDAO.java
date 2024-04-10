package com.emi.sprint1java.dao;

import com.emi.sprint1java.model.Cliente;

import java.util.List;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarId(int id);
    List<Cliente> buscarTodos();
    void editar(Cliente cliente);
    void deletar(int id);
}