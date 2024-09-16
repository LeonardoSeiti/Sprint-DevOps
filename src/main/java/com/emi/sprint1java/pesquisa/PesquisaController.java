package com.emi.sprint1java.pesquisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.emi.sprint1java.service.PesquisaService;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pesquisa")
@Tag(name = "Pesquisa", description = "API de Pesquisa")
public class PesquisaController {
    
    @Autowired
    PesquisaRepository repository;

    @Autowired
    PesquisaService service;

    @GetMapping
    public List<Pesquisa> index() {
        return repository.findAll();
    }

    @PostMapping
    public Pesquisa salvar(@RequestBody @Valid Pesquisa pesquisa){
       return repository.save(pesquisa); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pesquisa> mostrar (@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void destruir(@PathVariable Long id, Pesquisa pesquisa){
        verificarSePesquisaExiste(id);
        repository.delete(pesquisa);
        repository.deleteById(id);
    }

    private void verificarSePesquisaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }
}
