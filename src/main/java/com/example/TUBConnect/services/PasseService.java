/*package com.example.TUBConnect.services;

import com.example.TUBConnect.models.Passe;
import com.example.TUBConnect.models.Utilizador;
import com.example.TUBConnect.repositories.PasseRepository;
import com.example.TUBConnect.repositories.UtilizadorRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PasseService {

    private final PasseRepository passeRepository;
    private final UtilizadorRepository utilizadorRepository;

    public PasseService(PasseRepository passeRepository, UtilizadorRepository utilizadorRepository) {
        this.passeRepository = passeRepository;
        this.utilizadorRepository = utilizadorRepository;
    }

    public Passe comprarPasse(long utilizadorId, Passe.TipoPasse tipoPasse) {
        Optional<Utilizador> utilizadorOpt = utilizadorRepository.findById(utilizadorId);
        if (utilizadorOpt.isPresent() && utilizadorOpt.get().getTipo().equals("cliente")) {
            Passe passe = new Passe();
            passe.setUtilizador(utilizadorOpt.get());
            passe.setTipo(tipoPasse);
            passe.setData_compra(new Date());
            passe.setValidade(new Date(System.currentTimeMillis() + 2629746000L)); // 1 mês em milissegundos
            passe.setEstado(true);
            return passeRepository.save(passe);
        } else {
            throw new RuntimeException("Utilizador não é cliente ou não encontrado");
        }
    }



    public Passe renovarPasse(long passeId) {
        Optional<Passe> passeOpt = passeRepository.findById(passeId);
        if (passeOpt.isPresent()) {
            Passe passe = passeOpt.get();
            passe.setValidade(new Date(passe.getValidade().getTime() + 2629746000L)); // Renova por mais 1 mês
            passe.setEstado(true);
            return passeRepository.save(passe);
        } else {
            throw new RuntimeException("Passe não encontrado");
        }
    }

  /*  public Optional<Passe> encontrarPassePorUtilizadorId(long utilizadorId) {
        return passeRepository.findByUtilizador_utilizador_id(utilizadorId);
    }



}
 */
