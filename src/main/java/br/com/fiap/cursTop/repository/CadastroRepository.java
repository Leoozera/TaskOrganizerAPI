package br.com.fiap.cursTop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cursTop.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
