package com.emi.sprint1java.pesquisa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pesquisa")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pesquisa {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Nome não pode ser vazio")
    // Forma de comprometimento IP, domínio, hash
    private String indicador;
    @NotBlank(message = "Tipo não pode ser vazio")
    // Tipo  de ameaça malware, phishing
    private String tipo;
    //Url do site suspeito
    private String url;

}
