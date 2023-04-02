package br.com.fiap.cursTop.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Materia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @Min(0) @NotNull

    private BigDecimal duracao;

    @NotEmpty @Size(min = 5, max = 255)
    private String descricao;
    
    
    public Materia(String nome, BigDecimal duracao, String descricao) {
        this.nome = nome;
        this.duracao = duracao;
        this.descricao = descricao;
    }

    public Materia(){}

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

    public BigDecimal getduracao() {
        return duracao;
    }

    public void setduracao(BigDecimal duracao) {
        this.duracao = duracao;
    }
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
 
    @Override
    public String toString(){
        return "Materia [nome=" + nome + ", duracao=" + duracao + ", descricao=" + descricao + "]";
    }
    }

    
    

