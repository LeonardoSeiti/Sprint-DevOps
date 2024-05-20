package com.emi.sprint1java.controller;

import com.emi.sprint1java.exceptions.ClientDeleteException;
import com.emi.sprint1java.exceptions.ClientNotFoundException;
import com.emi.sprint1java.exceptions.ClientBadRequest;
import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    // GET
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar cliente por ID",
            description = "Retorna pesquisa de cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cadastro do cliente encontrado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    public ResponseEntity<Object> buscarId(@PathVariable int id) {
        Cliente cliente = service.getCliente(id);
        if (cliente != null) {
            cliente.setId_usuario(id);
            Cliente updatedCliente = service.save(cliente);
            String message = "Cliente atualizado com sucesso.";
            return ResponseEntity.ok().body(new UpdateResponse(cliente, message));
        } else {
            throw new ClientNotFoundException(id);
        }
    }

    // POST
    @PostMapping
    @Operation(
            summary = "Salvar cadastro cliente",
            description = "Salva cadastro do cliente")
    @ApiResponse(responseCode = "201", description = "Cadastro do cliente salvo")
    @ApiResponse(responseCode = "400", description = "Erro ao salvar cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.setCliente(cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar cadastro do cliente",
            description = "Deleta o cadastro do cliente")
    @ApiResponse(responseCode = "200", description = "Cadastro do cliente deletado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) {
        Cliente cliente = service.getCliente(id);
        if (cliente != null) {
            service.deleteCliente(id);
        } else {
            throw new ClientDeleteException(id);
        }
    }

    // PUT
    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar cadastro do cliente",
            description = "Atualiza cadastro do cliente")
    @ApiResponse(responseCode = "200", description = "Cadastro do cliente atualizado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente existente = service.getCliente(id);
        if (existente != null) {
            cliente.setId_usuario(id);
            Cliente updatedCliente = service.save(cliente);
            String message = "Cliente atualizado com sucesso.";
            return ResponseEntity.ok().body(new UpdateResponse(updatedCliente, message));
        } else {
            throw new ClientBadRequest(id);
        }
    }

    // Classe modelo para resposta de atualização
    static class UpdateResponse {
        private Cliente cliente;
        private String message;

        public UpdateResponse(Cliente cliente, String message) {
            this.cliente = cliente;
            this.message = message;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public String getMessage() {
            return message;
        }
    }
}
