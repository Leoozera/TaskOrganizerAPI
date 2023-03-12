package br.com.fiap.cursTop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cursTop.models.Cadastro;
import br.com.fiap.cursTop.models.ListarCadastro;

@RestController
public class CadastroController {

    @GetMapping("/api/ListarCadastro")
    @ResponseBody
    public ListarCadastro show(){
        ListarCadastro cadastro = ListarCadastro("405.914.580-71");
        return cadastro;
    }

    @PostMapping("/api/cadastro")
    @ResponseBody
    public Cadastro cadastrar(){
        Cadastro cadastro = new Cadastro("Pedro", "Vidal", "xxx@xxx.com.br", 18, "405.914.580-71");


    }
}
