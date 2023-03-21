package br.com.fiap.cursTop.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ListarMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public ListarMateria(String nome) {
        this.nome = nome;
    }

    public ListarMateria(){}



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
