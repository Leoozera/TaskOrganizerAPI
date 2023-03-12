package br.com.fiap.cursTop.controllers;


import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.ListarMateria;
import br.com.fiap.cursTop.models.Materia;

@RestController
public class MateriaControler {
    
    //getmapping para GET e postmapping para POST
    @GetMapping("/api/listarmateria")
    @ResponseBody
    public ListarMateria show(){
        ListarMateria materia = new ListarMateria("Python", (new BigDecimal(70)));
        return materia;
    }

    @PostMapping("/api/materia")
    @ResponseBody
    public Materia pesquisar(){
        Materia pesquisa = new Materia("orientação a objetos");
        return pesquisa;

    }


    

}
