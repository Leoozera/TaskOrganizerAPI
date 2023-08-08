package br.com.fiap.cursTop.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.models.Tarefa;
import br.com.fiap.cursTop.repository.MateriaRepository;
import br.com.fiap.cursTop.repository.TarefaRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired 
    MateriaRepository materiaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public void run(String... args) throws Exception {
        Materia m1 = new Materia(1L, "Python", new BigDecimal(40), "Python é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte.");
        materiaRepository.saveAll(List.of(m1));

        tarefaRepository.saveAll(List.of(
            Tarefa.builder().titulo("Aprimoramento em Machine learning").descricao("Exercicios para treinar uso de redes neurais.").materia(m1).build()
        ));
    }

    
    
}
