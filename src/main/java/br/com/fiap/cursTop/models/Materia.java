package br.com.fiap.cursTop.models;

import java.math.BigDecimal;


public class Materia {
    private Long id;
    
    private String nome;
    private BigDecimal tempo;
    private String descricao;
    
    
    public Materia(String nome, BigDecimal tempo, String descricao) {
        this.nome = nome;
        this.tempo = tempo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
 
    
    
    

}
