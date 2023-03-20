package br.com.fiap.cursTop.controllers;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Materia;

@RestController
public class MateriaController {
    
    Logger log = LoggerFactory.getLogger(MateriaController.class);

    List<Materia> materias = new ArrayList<>();

    @GetMapping("/api/materia")
    public List<Materia> index(){
        return materias;
    }

    @PostMapping("/api/materia")
        public ResponseEntity<Materia> create(@RequestBody Materia materia){
        log.info("Cadastrando usuário" + materia);
        materia.setId(materias.size() + 1l);
        materias.add(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(materia);
        }

    @GetMapping("/api/materia/{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id){
        log.info("Buscando materia com id " + id);
         var materiaEncontrado = materias.stream().filter(d -> d.getId().equals(id)).findFirst();
    
        if(materiaEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    
        return ResponseEntity.ok(materiaEncontrado.get());
    
    }

    @DeleteMapping("/api/materia/{id}")
    public ResponseEntity<Materia> destory(@PathVariable Long id){
        log.info("Apagando materia com id " + id);
        var cadastroEncontrado = materias.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        materias.remove(cadastroEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/api/materia/{id}")
    public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia materia){
        log.info("Atualizando materia com id " + id);
        var cadastroEncontrado = materias.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        materias.remove(cadastroEncontrado.get());
        materia.setId(id);
        materias.add(materia);


        return ResponseEntity.status(HttpStatus.OK).body(materia);

    }




    

}
