package br.com.fiap.cursTop.controllers;


import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Materia;

@RestController
public class MateriaControler {
    
    //getmapping para GET e postmapping para POST
    @GetMapping("/api/materia")
    public Materia show(){
        Materia materia = new Materia("Python", (new BigDecimal(70)));
        return materia;
    }

}
