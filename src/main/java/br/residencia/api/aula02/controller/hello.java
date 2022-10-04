package br.residencia.api.aula02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/ola")
    public String teste() {
        return "Hello World";
    }

    @GetMapping("/resposta")
    public String resposta(){
        return "Teste";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam String nome){
        return nome.toUpperCase();
    }
    //Criar um recurso para somar dois números e retornar o resultado:

    @GetMapping("/somar")
    public Integer somar(@RequestParam Integer numero1,@RequestParam Integer numero2){
        return numero1 + numero2;
    } 
}
