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
import br.com.fiap.cursTop.models.Cadastro;
import br.com.fiap.cursTop.models.Tarefa;
import br.com.fiap.cursTop.repository.TarefaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    Logger log = LoggerFactory.getLogger(TarefaController.class);

    @Autowired
    TarefaRepository repository; // IoD


    @GetMapping
    public List<Tarefa> index(){
        return repository.findAll();
    }
    

    @PostMapping
        public ResponseEntity<Tarefa> create(@RequestBody @Valid Tarefa tarefa){
        log.info("Cadastrando tarefa" + tarefa);

        repository.save(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
        }


    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscando tarefa com id " + id);
        var tarefa = getTarefa(id);

        return ResponseEntity.ok(tarefa);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destory(@PathVariable Long id){
        log.info("Apagando tarefa com id " + id);
        var tarefa = getTarefa(id);

        repository.delete(tarefa);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        log.info("Atualizando usuario com id " + id);
        getTarefa(id);

        tarefa.setId(id);
        repository.save(tarefa);

        return ResponseEntity.ok(tarefa);

    }


    private Tarefa getTarefa(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("cadastro não encontrada"));
    }

}


    

