package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.Rota;
import com.example.TUBConnect.services.RotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    private final RotaService rotaService;

    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @GetMapping
    public List<Rota> getAllRotas() {
        return rotaService.findAllRotas();
    }

    @PostMapping("/criarRota")
    public Rota createRota(@RequestBody Rota rota) {

        return rotaService.saveRota(rota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> getRotaById(@PathVariable Long id) {
        return rotaService.findRotaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
