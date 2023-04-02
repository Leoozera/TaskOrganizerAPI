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
public class MateriaController{
    
    Logger log = LoggerFactory.getLogger(MateriaController.class);

    

    @Autowired
    MateriaRepository repository; // IoD spring entregando o objeto pronto para que não tenha que instanciar / injeção de dependencia.

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Materia materia){
        //if(result.hasErrors()) return ResponseEntity.badRequest().body(new RestValidationError("erro de validação")); // ao inves de fazer o buld com o badRequest, uso o body e passo um objeto(model) e como no método é dito que a resposta é um responde entity de materia vai dar erro por isso trocamos por Object (tudo é object)
        
        log.info("Cadastrando materia " + materia.getNome());
        
        repository.save(materia);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(materia);
    }

    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id){
        log.info("Buscando materia com id " + id);
         var materia = getMateria(id);
    
        return ResponseEntity.ok(materia);
    
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Materia> destory(@PathVariable Long id){
        log.info("Apagando materia com id " + id);
        var materia = getMateria(id);

        repository.delete(materia);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid Materia materia) {
        //if(result.hasErrors()) return ResponseEntity.badRequest().body(new RestValidationError("erro de validação")); 
        log.info("Atualizando materia com id " + id);
       getMateria(id);

        
        materia.setId(id);
        repository.save(materia);


        return ResponseEntity.status(HttpStatus.OK).body(materia);

    }

    private Materia getMateria(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("materia não encontrada"));
    }




    

}
