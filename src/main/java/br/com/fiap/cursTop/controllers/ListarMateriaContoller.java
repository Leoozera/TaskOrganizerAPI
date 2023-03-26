package br.com.fiap.cursTop.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.ListarMateria;
import br.com.fiap.cursTop.repository.ListarMateriaRepository;


@RestController
public class ListarMateriaContoller {

    Logger log = LoggerFactory.getLogger(ListarMateriaContoller.class);

    @Autowired
    ListarMateriaRepository repository;

    @GetMapping
    public List<ListarMateria> index(){
        return repository.findAll();
    }


    
}
