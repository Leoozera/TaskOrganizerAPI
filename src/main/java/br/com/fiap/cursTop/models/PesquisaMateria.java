package br.com.fiap.cursTop.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PesquisaMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull @Size(min = 5)
    private Long id;

    @NotNull
    private String nome;


   
}
