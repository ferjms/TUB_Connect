package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.utilizador;
import com.example.TUBConnect.repositories.utilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilizador")
public class utilizadorController {

    @Autowired
    private utilizadorRepository repository;
    @GetMapping
    public List<utilizador> getAll(){

        List<utilizador> listaUtilizadores = repository.findAll();
        return listaUtilizadores;

    }

    @PostMapping
    public void criarUtilizador(@RequestBody utilizador novoUtilizador) {
        utilizador usuarioCriado = repository.save(novoUtilizador);
        return;
    }
}
