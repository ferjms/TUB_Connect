package com.example.TUBConnect.services;

import com.example.TUBConnect.models.Autocarro;
import com.example.TUBConnect.repositories.AutocarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutocarroService {

    private final AutocarroRepository autocarroRepository;

    @Autowired
    public AutocarroService(AutocarroRepository autocarroRepository) {
        this.autocarroRepository = autocarroRepository;
    }

    public List<Autocarro> listarAutocarros() {
        return autocarroRepository.findAll();
    }

    public Autocarro salvarAutocarro(Autocarro autocarro) {
        return autocarroRepository.save(autocarro);
    }

    public void apagarAutocarro(Long autocarroId) {
        autocarroRepository.deleteById(autocarroId);
    }
    public List<Autocarro> listarAutocarrosPorRota(Long rotaId) {
        return autocarroRepository.findByRotaId(rotaId);  // Chama o método personalizado no repositório
    }
}

