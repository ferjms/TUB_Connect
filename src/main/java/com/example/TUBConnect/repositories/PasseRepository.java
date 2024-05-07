package com.example.TUBConnect.repositories;

import com.example.TUBConnect.models.Passe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PasseRepository extends JpaRepository<Passe, Long> {

    Optional<Passe> findByUtilizador_UtilizadorId(long utilizadorId);
}



