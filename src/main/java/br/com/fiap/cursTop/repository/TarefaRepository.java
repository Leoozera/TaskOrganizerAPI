package br.com.fiap.cursTop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cursTop.models.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{
    
}
