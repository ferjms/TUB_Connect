package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.utilizador;
import com.example.TUBConnect.repositories.utilizadorRepository;
import com.example.TUBConnect.services.utilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilizador")
public class utilizadorController {

    private final utilizadorService userService;

    @Autowired
    private utilizadorRepository userRepository;

    @Autowired
    public utilizadorController(utilizadorService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<utilizador> listarUtilizadores() {
        return userService.listarUtilizadores();
        }

    @PostMapping
    public void criarUtilizador(@RequestBody utilizador user) {
        utilizadorService.addNewUser(user);
    }
}