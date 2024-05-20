package com.emi.sprint1java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "T_USUARIO")
public class Cliente {

    @Id
    private int id_usuario;

    private String ds_email;

    private String ds_senha;

    @NotBlank
    private String nm_usuario;

    @NotBlank
    private String nm_empresa;

    private String nm_departamento;
}
