package com.emi.sprint1java.dao;

import com.emi.sprint1java.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findById(int id);
    Cliente save(Cliente cliente);
}