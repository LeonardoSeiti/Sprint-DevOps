package com.emi.sprint1java.model;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
public class Cliente {

    @Id
    int id;
    String nome;
    String razaoSocial;
    String email;

    String senha;

    public void iniciarAtendimento(){

    }

    public void enviarMensagem(){

    }

    public void encerrarAtendimento(){

    }

    public void loginCliente(){

    }

    public void cadastroCliente(){
        
    }
}
