package com.example.TUBConnect.services;

import com.example.TUBConnect.models.Rota;
import com.example.TUBConnect.repositories.RotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;

    public RotaService(RotaRepository rotaRepository) {
        this.rotaRepository = rotaRepository;
    }

    public List<Rota> findAllRotas() {
        return rotaRepository.findAll();
    }

    public Rota saveRota(Rota rota) {
        return rotaRepository.save(rota);
    }

    public Optional<Rota> findRotaById(Long id) {
        return rotaRepository.findById(id);
    }
}
