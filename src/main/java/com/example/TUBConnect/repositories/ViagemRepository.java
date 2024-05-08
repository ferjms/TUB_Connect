package com.example.TUBConnect.repositories;

import com.example.TUBConnect.models.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    List<Viagem> findByUtilizadorId(Long utilizadorId);
}
