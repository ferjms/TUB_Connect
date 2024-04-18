package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.Utilizador;

import com.example.TUBConnect.repositories.UtilizadorRepository;
import com.example.TUBConnect.services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Utilizador")
public class UtilizadorController {

    private final UtilizadorService utilizadorService;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping
    public List<Utilizador> listarUtilizadores() {
        return utilizadorService.listarUtilizadores();
        }

    @PostMapping
    public void criarUtilizador(@RequestBody Utilizador utilizador) {
        utilizadorService.addNewUser(utilizador);
    }

    @DeleteMapping(path = "{utilizadorID}")
    public void apagarUtilizador(@PathVariable("utilizadorID")Long utilizadorID){
        utilizadorService.apagarUtilizador(utilizadorID);
    }

    @PutMapping(path = "{utilizadorID}")
    public void atualizarUtilizador(
            @PathVariable("utilizadorID")Long utilizadorID,
            @RequestParam(required = false)String nome,
           // @RequestParam(required = false)String email,
            @RequestParam(required = false)String password,
            @RequestParam(required = false)String tipo,
            @RequestParam(required = false)String nacionalidade,
            @RequestParam(required = false)String idiomaPreferido,
            @RequestParam(required = false)String telefone ) {
            utilizadorService.atualizarUtilizador(utilizadorID,nome,password,tipo,nacionalidade,idiomaPreferido,telefone);
    }
}