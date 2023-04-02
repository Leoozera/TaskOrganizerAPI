package br.com.fiap.cursTop.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.repository.MateriaRepository;


@RestController
public class PesquisaMateriaContoller {

    Logger log = LoggerFactory.getLogger(PesquisaMateriaContoller.class);

    @Autowired
    MateriaRepository repository;

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    


    
}
