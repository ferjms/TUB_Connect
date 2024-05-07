package com.example.TUBConnect.controllers;
import com.example.TUBConnect.models.Utilizador;
import com.example.TUBConnect.repositories.UtilizadorRepository;


import com.example.TUBConnect.models.Passe;
import com.example.TUBConnect.services.PasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tub/passes")
public class PasseController {

    private final PasseService passeService;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    public PasseController(PasseService passeService) {
        this.passeService = passeService;
    }

    @PostMapping("/comprarPasse/{utilizadorId}/{rotaId}")
    public ResponseEntity<?> comprarPasse(@PathVariable long utilizadorId, @PathVariable Long rotaId, @RequestBody Passe.TipoPasse tipoPasse) {
        Optional<Utilizador> utilizadorOpt = utilizadorRepository.findById(utilizadorId);
        if (!utilizadorOpt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilizador não encontrado");
        } else if (!utilizadorOpt.get().getTipo().equalsIgnoreCase("cliente")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Utilizador não é cliente");
        }
        try {
            Passe passe = passeService.comprarPasse(utilizadorId, tipoPasse, rotaId);
            return ResponseEntity.ok(passe);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @GetMapping("/passe/{utilizadorId}")
    public ResponseEntity<?> listarPasse(@PathVariable long utilizadorId) {
        try {
            Optional<Passe> passeOpt = passeService.encontrarPassePorUtilizadorId(utilizadorId);
            if (passeOpt.isPresent()) {
                Passe passe = passeOpt.get();
                Map<String, Object> passeInfo = new HashMap<>();
                passeInfo.put("passeId", passe.getPasseId());
                passeInfo.put("tipoPasse", passe.getTipo());
                passeInfo.put("validade", passe.getValidade());
                passeInfo.put("estado", passe.isEstado());

                // Verifica se o passe está vencido para indicar se pode ser renovado
                boolean podeRenovar = !passe.getValidade().before(new Date());
                passeInfo.put("podeRenovar", podeRenovar);

                return ResponseEntity.ok(passeInfo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/renovar/{passeId}")
    public ResponseEntity<Passe> renovarPasse(@PathVariable long passeId) {
        try {
            Passe passe = passeService.renovarPasse(passeId);
            return ResponseEntity.ok(passe);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}

