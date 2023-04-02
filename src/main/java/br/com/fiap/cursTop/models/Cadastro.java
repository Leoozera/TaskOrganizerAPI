package br.com.fiap.cursTop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String email;

    @NotNull
    private String dtNascimento;

    @NotNull @Size(min = 11)
    private String cpf;

    
    public Cadastro(String nome, String sobrenome, String email, String dtNascimento, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dtNascimento = dtNascimento; 
        this.cpf = cpf;
    }

    protected Cadastro (){}


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getdtNascimento() {
        return dtNascimento;
    }
    public void setdtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Cadastro [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", dtNascimento=" + dtNascimento
                + ", cpf=" + cpf + "]";
    }
    
    
}
