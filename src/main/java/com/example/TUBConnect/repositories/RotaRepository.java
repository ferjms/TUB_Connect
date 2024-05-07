package com.example.TUBConnect.repositories;

import com.example.TUBConnect.models.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaRepository extends JpaRepository<Rota, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
