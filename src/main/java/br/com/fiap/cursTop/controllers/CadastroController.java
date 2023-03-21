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

import br.com.fiap.cursTop.models.Cadastro;
import br.com.fiap.cursTop.repository.CadastroRepository;


@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    Logger log = LoggerFactory.getLogger(CadastroController.class);

    List<Cadastro> cadastros = new ArrayList<>();

    @Autowired
    CadastroRepository repository; // IoD


    @GetMapping
    public List<Cadastro> index(){
        return cadastros;
    }
    

    @PostMapping
        public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastro){
        log.info("Cadastrando usuário" + cadastro);

        repository.save(cadastro);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
        }


    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("Buscando usuario com id " + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(cadastroEncontrado.get());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> destory(@PathVariable Long id){
        log.info("Apagando usuario com id " + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.notFound().build();

        repository.delete(cadastroEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro cadastro){
        log.info("Atualizando usuario com id " + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        cadastro.setId(id);
        repository.save(cadastro);

        return ResponseEntity.ok(cadastro);

    }



}


    

