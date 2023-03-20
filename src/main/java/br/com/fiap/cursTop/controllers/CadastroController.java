package br.com.fiap.cursTop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Cadastro;
import br.com.fiap.cursTop.models.ListaCadastro;


@RestController
public class CadastroController {

    Logger log = LoggerFactory.getLogger(CadastroController.class);

    List<Cadastro> cadastros = new ArrayList<>();

    @GetMapping("/api/ListaCadastro")
    public List<Cadastro> index(){
        return cadastros;
    }
    

    @PostMapping("/api/cadastro")
        public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastro){
        log.info("Cadastrando usuário" + cadastro);
        cadastro.setId(cadastros.size() + 1l);
        cadastros.add(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
        }


    @GetMapping("/api/cadastro/{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("Buscando usuario com id " + id);
        var cadastroEncontrado = cadastros.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(cadastroEncontrado.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(cadastroEncontrado.get());

    }
}


    

