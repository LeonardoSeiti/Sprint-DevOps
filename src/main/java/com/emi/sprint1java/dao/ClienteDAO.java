package com.emi.sprint1java.dao;

import com.emi.sprint1java.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO extends JpaRepository   <Cliente, Long> {
    static void salvar(Cliente cliente) {

    }

    default Cliente buscarId(int id) {
        return null;
    };
    default List<Cliente> buscarTodos() {
        return null;
    };

    static void editar(Cliente cliente) {

    }

    static void deletar(int id) {

    }
}