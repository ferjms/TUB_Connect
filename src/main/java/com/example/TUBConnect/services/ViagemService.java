package com.example.TUBConnect.services;

import com.example.TUBConnect.models.Viagem;
import com.example.TUBConnect.repositories.ViagemRepository;
import com.example.TUBConnect.repositories.UtilizadorRepository;
import com.example.TUBConnect.repositories.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    private RotaRepository rotaRepository;

    @Transactional
    public Viagem comprarViagem(Long utilizadorId, Long rotaId, Viagem.Coroa coroa) throws Exception {
        if (!utilizadorRepository.existsById(utilizadorId)) {
            throw new Exception("Utilizador não encontrado.");
        }
        if (!rotaRepository.existsById(rotaId)) {
            throw new Exception("Rota não encontrada.");
        }

        Viagem viagem = new Viagem();
        viagem.setUtilizadorId(utilizadorId);
        viagem.setRotaId(rotaId);
        viagem.setDataCompra(LocalDate.now());
        viagem.setPreco(coroa.getPreco());
        viagem.setEstado(true);
        viagem.setCoroa(coroa);
        return viagemRepository.save(viagem);
    }


    public List<Viagem> listarViagensPorUtilizador(Long utilizadorId) {
        return viagemRepository.findByUtilizadorId(utilizadorId);
    }
}
