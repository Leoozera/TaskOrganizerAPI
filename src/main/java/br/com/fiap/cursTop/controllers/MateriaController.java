package br.com.fiap.cursTop.controllers;


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

import br.com.fiap.cursTop.exception.RestNotFoundException;
import br.com.fiap.cursTop.models.Materia;
import br.com.fiap.cursTop.repository.MateriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {

    Logger log = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    MateriaRepository repository;

    @GetMapping
    public List<Materia> index() {
        log.info("Realizando listagem de matérias");

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id) {
        log.info("Realizando busca de matéria com id: " + id);
        Materia materia = getMateria(id);

        return ResponseEntity.ok(materia);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid Materia materia) {
        log.info("Realizando atualização do cadastro com id: " + id);
        getMateria(id);

        materia.setId(id);
        repository.save(materia);

        return ResponseEntity.status(HttpStatus.OK).body(materia);

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Materia materia) {
        log.info("Realizando cadastro de matéria com nome: " + materia.getNome());

        repository.save(materia);

        return ResponseEntity.status(HttpStatus.CREATED).body(materia);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Materia> destory(@PathVariable Long id) {
        log.info("Realizando exclusão de matéria com id: " + id);
        var materia = getMateria(id);

        repository.delete(materia);

        return ResponseEntity.noContent().build();

    }

    private Materia getMateria(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Ocorreu um erro ao realizar a busca da matéria de id:" + id));
    }


}
