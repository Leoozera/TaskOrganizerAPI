package br.com.fiap.cursTop.controllers;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.repository.MateriaRepository;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {
    
    Logger log = LoggerFactory.getLogger(MateriaController.class);

    List<Materia> materias = new ArrayList<>();

    @Autowired
    MateriaRepository repository; // IoD

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    @PostMapping
        public ResponseEntity<Materia> create(@RequestBody Materia materia){
        log.info("Cadastrando materia" + materia);
        
            repository.save(materia);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(materia);
        }

    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id){
        log.info("Buscando materia com id " + id);
         var materiaEncontrado = repository.findById(id);
    
        if(materiaEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    
        return ResponseEntity.ok(materiaEncontrado.get());
    
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Materia> destory(@PathVariable Long id){
        log.info("Apagando materia com id " + id);
        var materiaEncontrado = repository.findById(id);

        if(materiaEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(materiaEncontrado.get());

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia materia){
        log.info("Atualizando materia com id " + id);
        var materiaEncontrado = repository.findById(id);

        if(materiaEncontrado.isEmpty())
             return ResponseEntity.notFound().build();

        
        materia.setId(id);
        repository.save(materia);


        return ResponseEntity.status(HttpStatus.OK).body(materia);

    }




    

}
