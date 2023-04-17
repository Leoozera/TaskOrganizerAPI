package br.com.fiap.cursTop.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.models.Tarefa;
import br.com.fiap.cursTop.repository.MateriaRepository;
import br.com.fiap.cursTop.repository.TarefaRepository;

public class DataBaseSeeder implements CommandLineRunner{

    @Autowired 
    MateriaRepository materiaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public void run(String... args) throws Exception {
        Materia m1 = new Materia(1L, "Python", new BigDecimal(40), "Python é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte.");
        Materia m2 = new Materia(2L, "Java", new BigDecimal(80), "Java é uma linguagem de programação orientada a objetos");
        Materia m3 = new Materia(3L, "HTML E CSS", new BigDecimal(20), "Cascading Style Sheets é um mecanismo para adicionar estilos a uma página web");
        Materia m4 = new Materia(4L, "Big Data", new BigDecimal(50), "Big data é a área do conhecimento que estuda como tratar, analisar e obter informações a partir de conjuntos de dados muito grandes");
        materiaRepository.saveAll(List.of(m1,m2,m3,m4));

        tarefaRepository.saveAll(List.of(
            Tarefa.builder().titulo("Espacamento interno").descricao("padding").materia(m3).build(),
            Tarefa.builder().titulo("Espacamento externo").descricao("Exercicios para treinar uso de margin dentro no bloco main").materia(m3).build(),
            Tarefa.builder().titulo("Sombra").descricao("Exercicios para treinar uso de shadow bow dentro no bloco main").materia(m3).build(),
            Tarefa.builder().titulo("Formularios").descricao("Exercicios para treinar uso de formularios dentro no bloco main").materia(m3).build(),
            Tarefa.builder().titulo("Check-Box").descricao("Exercicios para treinar uso de Check-Box dentro no bloco main").materia(m3).build()
        ));
    }

    
    
}
