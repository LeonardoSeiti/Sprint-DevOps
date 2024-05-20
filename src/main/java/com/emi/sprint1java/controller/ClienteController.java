package com.emi.sprint1java.controller;

import com.emi.sprint1java.exceptions.ClientNotFoundException;
import com.emi.sprint1java.model.Cliente;
import com.emi.sprint1java.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<Cliente> buscarId(@PathVariable int id) {
        Cliente cliente = service.getCliente(id);
        if (cliente == null) {
            throw new ClientNotFoundException(id);
        }
        EntityModel<Cliente> resource = EntityModel.of(cliente);
        resource.add(linkTo(methodOn(ClienteController.class).buscarId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ClienteController.class).salvar(cliente)).withRel("salvar"));
        resource.add(linkTo(methodOn(ClienteController.class).deletar(id)).withRel("deletar"));
        resource.add(linkTo(methodOn(ClienteController.class).atualizar(id, cliente)).withRel("atualizar"));
        return resource;
    }

    // POST
    @PostMapping
    @Operation(
            summary = "Salvar cadastro cliente",
            description = "Salva cadastro do cliente")
    @ApiResponse(responseCode = "201", description = "Cadastro do cliente salvo")
    @ApiResponse(responseCode = "400", description = "Erro ao salvar cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<Cliente>> salvar(@RequestBody Cliente cliente) {
        Cliente savedCliente = service.setCliente(cliente);
        EntityModel<Cliente> resource = EntityModel.of(savedCliente);
        resource.add(linkTo(methodOn(ClienteController.class).buscarId(savedCliente.getId_usuario())).withSelfRel());
        resource.add(linkTo(methodOn(ClienteController.class).salvar(cliente)).withRel("salvar"));
        resource.add(linkTo(methodOn(ClienteController.class).deletar(savedCliente.getId_usuario())).withRel("deletar"));
        resource.add(linkTo(methodOn(ClienteController.class).atualizar(savedCliente.getId_usuario(), cliente)).withRel("atualizar"));
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar cadastro do cliente",
            description = "Deleta o cadastro do cliente")
    @ApiResponse(responseCode = "200", description = "Cadastro do cliente deletado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deletar(@PathVariable int id) {
        Cliente cliente = service.getCliente(id);
        if (cliente == null) {
            throw new ClientNotFoundException(id);
        }
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    // PUT
    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar cadastro do cliente",
            description = "Atualiza cadastro do cliente")
    @ApiResponse(responseCode = "200", description = "Cadastro do cliente atualizado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    public ResponseEntity<EntityModel<Cliente>> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente existente = service.getCliente(id);
        if (existente == null) {
            throw new ClientNotFoundException(id);
        }
        cliente.setId_usuario(id);
        Cliente updatedCliente = service.save(cliente);
        EntityModel<Cliente> resource = EntityModel.of(updatedCliente);
        resource.add(linkTo(methodOn(ClienteController.class).buscarId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ClienteController.class).salvar(cliente)).withRel("salvar"));
        resource.add(linkTo(methodOn(ClienteController.class).deletar(id)).withRel("deletar"));
        resource.add(linkTo(methodOn(ClienteController.class).atualizar(id, cliente)).withRel("atualizar"));
        return ResponseEntity.ok(resource);
    }


    static class OperationResponse {
        private Cliente cliente;
        private String message;

        public OperationResponse(Cliente cliente, String message) {
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
