package com.example.TUBConnect.services;

import com.example.TUBConnect.models.Passe;
import com.example.TUBConnect.models.Rota;
import com.example.TUBConnect.models.Utilizador;
import com.example.TUBConnect.repositories.PasseRepository;
import com.example.TUBConnect.repositories.RotaRepository;
import com.example.TUBConnect.repositories.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PasseService {

    private final PasseRepository passeRepository;
    private final UtilizadorRepository utilizadorRepository;
    private final RotaRepository rotaRepository;  // Adicionar esta linha

    @Autowired // Esta anotação pode ser opcional se você está usando a injeção através do construtor
    public PasseService(PasseRepository passeRepository, UtilizadorRepository utilizadorRepository, RotaRepository rotaRepository) {
        this.passeRepository = passeRepository;
        this.utilizadorRepository = utilizadorRepository;
        this.rotaRepository = rotaRepository; // Inicializar no construtor
    }

    public Passe comprarPasse(long utilizadorId, Passe.TipoPasse tipoPasse, int coroa) {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId)
                .orElseThrow(() -> new RuntimeException("Utilizador não encontrado"));

        double preco = calcularPrecoPasse(tipoPasse, coroa);

        if (preco < 0) {
            throw new RuntimeException("Este tipo de passe não é válido para a coroa selecionada.");
        }

        Passe passe = new Passe();
        passe.setUtilizador(utilizador);
        passe.setCoroa(coroa); // Configura a coroa diretamente
        passe.setTipo(tipoPasse);
        passe.setPreco(preco);
        passe.setData_compra(new Date());
        passe.setValidade(new Date(System.currentTimeMillis() + 2629746000L)); // 1 mês em milissegundos
        passe.setEstado(true);
        return passeRepository.save(passe);
    }


    private double calcularPrecoPasse(Passe.TipoPasse tipoPasse, int coroa) {
        switch (tipoPasse) {
            case ESTUDANTE:
                return coroa == 1 ? 20 : -1; // Retorna -1 se for inválido para a coroa
            case REFORMADO:
                return 5; // Preço fixo para todas as coroas
            case FUNCIONARIO:
                return 0; // Continua a ser gratuito para funcionários
            case JOVEM_MUNICIPE:
                return coroa == 2 ? 15 : -1; // Retorna -1 se for inválido para a coroa
            case PCD:
                return 10; // Preço fixo para todas as coroas
            default:
                throw new IllegalArgumentException("Tipo de passe inválido");
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

   public Optional<Passe> encontrarPassePorUtilizadorId(long utilizadorId) {
        return passeRepository.findByUtilizador_UtilizadorId(utilizadorId);
    }



}

