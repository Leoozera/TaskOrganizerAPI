package br.com.fiap.cursTop.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PesquisaMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull @Size(min = 5)
    private Long id;

    @NotNull
    private String nome;

    public PesquisaMateria(String nome) {
        this.nome = nome;
    }

    public PesquisaMateria(){}



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



   
}
