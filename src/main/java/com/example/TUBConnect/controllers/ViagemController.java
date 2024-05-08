package com.example.TUBConnect.controllers;

import com.example.TUBConnect.models.Viagem;
import com.example.TUBConnect.services.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @PostMapping("/comprarViagem/{utilizadorId}/{rotaId}/{coroa}")
    public ResponseEntity<?> comprarViagem(@PathVariable Long utilizadorId, @PathVariable Long rotaId, @PathVariable String coroa) {
        try {
            Viagem.Coroa tipoCoroa = Viagem.Coroa.valueOf(coroa.toUpperCase()); // Convert string to enum
            Viagem viagem = viagemService.comprarViagem(utilizadorId, rotaId, tipoCoroa);
            return ResponseEntity.ok(viagem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Tipo de coroa inválido.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/listarViagens/{utilizadorId}")
    public List<Viagem> listarViagensPorUtilizador(@PathVariable Long utilizadorId) {
        return viagemService.listarViagensPorUtilizador(utilizadorId);
    }
}
