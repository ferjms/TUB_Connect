package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.Autocarro;
import com.example.TUBConnect.services.AutocarroService;
import com.example.TUBConnect.repositories.AutocarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autocarros")
public class AutocarroController {

    private final AutocarroService autocarroService;

    @Autowired
    public AutocarroController(AutocarroService autocarroService) {
        this.autocarroService = autocarroService;
    }

    @GetMapping
    public List<Autocarro> listarAutocarros() {
        return autocarroService.listarAutocarros();
    }

    @PostMapping("/criarAutocarro")
    public Autocarro criarAutocarro(@RequestBody Autocarro autocarro) {
        return autocarroService.salvarAutocarro(autocarro);
    }

    @DeleteMapping("/{autocarroId}")
    public ResponseEntity<?> apagarAutocarro(@PathVariable Long autocarroId) {
        autocarroService.apagarAutocarro(autocarroId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rota/{rotaId}")
    public List<Autocarro> listarAutocarrosPorRota(@PathVariable Long rotaId) {
        return autocarroService.listarAutocarrosPorRota(rotaId);
    }

}
