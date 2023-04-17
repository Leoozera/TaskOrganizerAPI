package br.com.fiap.cursTop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cursTop.models.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

    
    List<Tarefa> findByDescricao (String descricao);
    
}
