package br.com.fiap.cursTop.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.repository.MateriaRepository;

public class DataBaseSeeder implements CommandLineRunner{

    @Autowired 
    MateriaRepository materiaRepository;

    @Override
    public void run(String... args) throws Exception {
        materiaRepository.saveAll(List.of(
        new Materia(1L, "Python", new BigDecimal(40), "Python é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte."),
        new Materia(2L, "Java", new BigDecimal(80), "Java é uma linguagem de programação orientada a objetos"),
        new Materia(3L, "CSS", new BigDecimal(20), "Cascading Style Sheets é um mecanismo para adicionar estilos a uma página web")


        ));
    }

    
    
}
