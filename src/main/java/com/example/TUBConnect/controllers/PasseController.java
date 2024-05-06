/*package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.Passe;
import com.example.TUBConnect.services.PasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tub/passes")
public class PasseController {

    private final PasseService passeService;

    public PasseController(PasseService passeService) {
        this.passeService = passeService;
    }

    @PostMapping("/comprarPasse/{utilizadorId}")
    public ResponseEntity<Passe> comprarPasse(@PathVariable long utilizadorId, @RequestBody Passe.TipoPasse tipoPasse) {
        try {
            Passe passe = passeService.comprarPasse(utilizadorId, tipoPasse);
            return ResponseEntity.ok(passe);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

   /* @GetMapping("/passe/{utilizadorId}")
    public ResponseEntity<?> listarPasse(@PathVariable long utilizadorId) {
        try {
            Optional<Passe> passeOpt = passeService.encontrarPassePorUtilizadorId(utilizadorId);
            if (passeOpt.isPresent()) {
                Passe passe = passeOpt.get();
                Map<String, Object> passeInfo = new HashMap<>();
                passeInfo.put("passeId", passe.getPasse_id());
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


}*/

