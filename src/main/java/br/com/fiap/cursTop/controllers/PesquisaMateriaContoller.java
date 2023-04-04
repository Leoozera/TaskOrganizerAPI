package br.com.fiap.cursTop.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.exception.RestNotFoundException;
import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.repository.MateriaRepository;


@RestController
@RequestMapping("/api/pesquisamateria")
public class PesquisaMateriaContoller {

    Logger log = LoggerFactory.getLogger(PesquisaMateriaContoller.class);

    @Autowired
    MateriaRepository repository;

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id){
        log.info("Buscando materia com id " + id);
         var materia = getMateria(id);
    
        return ResponseEntity.ok(materia);
    
    }

    private Materia getMateria(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("materia não encontrada"));
    }
    


    
}
