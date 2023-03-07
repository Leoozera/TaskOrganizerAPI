package br.com.fiap.cursTop.models;

import java.math.BigDecimal;

public class Materia {

    private String nome;
    private BigDecimal tempo;

    

    public Materia(String nome, BigDecimal tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTempo() {
        return tempo;
    }

    public void setTempo(BigDecimal tempo) {
        this.tempo = tempo;
    }
 
    

    

}
