package br.com.fiap.cursTop.models;

public class Cadastro {

    private String nome;
    private String sobrenome;
    private String email;
    private int idade;
    private String cpf;

    
    public Cadastro(String nome, String sobrenome, String email, int idade, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade; 
        this.cpf = cpf;
    }


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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Cadastro [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", idade=" + idade
                + ", cpf=" + cpf + "]";
    }

    
    
}
