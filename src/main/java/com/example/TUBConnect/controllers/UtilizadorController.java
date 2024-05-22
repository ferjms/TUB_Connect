package com.example.TUBConnect.controllers;

import com.example.TUBConnect.repositories.UtilizadorRepository;
import com.example.TUBConnect.models.Utilizador;
import com.example.TUBConnect.services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://10.0.2.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/tub")
public class UtilizadorController {
    private final UtilizadorService utilizadorService;

    @Autowired
    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping("/user/listar")
    public List<Utilizador> listarUtilizadores() {
        return utilizadorService.listarUtilizadores();
    }

    @PostMapping("/user/registar")
    public void criarUtilizador(@RequestBody Utilizador utilizador) {
        utilizadorService.addNewUser(utilizador);
    }

    @DeleteMapping(path = "/user/{utilizadorId}")
    public void apagarUtilizador(@PathVariable("utilizadorId") Long utilizadorId) {
        utilizadorService.apagarUtilizador(utilizadorId);
    }

    @PutMapping(path = "{utilizadorId}")
    public void atualizarUtilizador(
            @PathVariable("utilizadorId") Long utilizadorId,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String nacionalidade,
            @RequestParam(required = false) String idiomaPreferido,
            @RequestParam(required = false) String telefone) {
        utilizadorService.atualizarUtilizador(utilizadorId, nome, password, tipo, nacionalidade, idiomaPreferido, telefone);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody Utilizador loginRequest) {
        return utilizadorService.login(loginRequest.getEmail(), loginRequest.getPassword())
                .map(user -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Login successful!");
                    response.put("tipoUtilizador", user.getTipo());
                    return ResponseEntity.ok().body(response);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("mensagem de erro", "Credenciais inválidas")));
    }
}
