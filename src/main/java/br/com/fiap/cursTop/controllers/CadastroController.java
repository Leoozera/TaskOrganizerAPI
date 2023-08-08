package br.com.fiap.cursTop.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import br.com.fiap.cursTop.repository.CadastroRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    Logger log = LoggerFactory.getLogger(CadastroController.class);

    @Autowired
    CadastroRepository repository;

    @GetMapping
    public List<Cadastro> index() {
        log.info("Realizando listagem de cadastros");

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id) {
        log.info("Realizando busca de cadastro com id: " + id);
        Cadastro cadastro = getCadastro(id);

        return ResponseEntity.ok(cadastro);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody @Valid Cadastro cadastro) {
        log.info("Realizando atualização do cadastro com id: " + id);
        getCadastro(id);

        cadastro.setId(id);
        repository.save(cadastro);

        return ResponseEntity.ok(cadastro);
    }

    @PostMapping
    public ResponseEntity<Cadastro> create(@RequestBody @Valid Cadastro cadastro) {
        log.info("Realizando cadastro de usuário com email: " + cadastro.getEmail());

        repository.save(cadastro);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> destory(@PathVariable Long id) {
        log.info("Realizando exclusão de usuário com id: " + id);
        Cadastro cadastro = getCadastro(id);

        repository.delete(cadastro);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    private Cadastro getCadastro(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Ocorreu um erro ao realizar a busca do cadastro de id:" + id));
    }

}


    

