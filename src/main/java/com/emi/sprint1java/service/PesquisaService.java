package com.emi.sprint1java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.emi.sprint1java.pesquisa.Pesquisa;
import com.emi.sprint1java.pesquisa.PesquisaRepository;

@Service
public class PesquisaService {

    @Autowired
    PesquisaRepository repository;

    public Pesquisa setUsuario(Pesquisa pesquisa) {
        return repository.save(pesquisa);
    }
}