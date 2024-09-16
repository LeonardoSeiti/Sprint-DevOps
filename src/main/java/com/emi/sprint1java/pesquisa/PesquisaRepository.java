package com.emi.sprint1java.pesquisa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    Pesquisa save(Pesquisa pesquisa);

}
