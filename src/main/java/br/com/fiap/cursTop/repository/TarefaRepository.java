package br.com.fiap.cursTop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cursTop.models.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

    
    Page<Tarefa> findByDescricaoContaining (String descricao, Pageable pageable);

   
    
}
