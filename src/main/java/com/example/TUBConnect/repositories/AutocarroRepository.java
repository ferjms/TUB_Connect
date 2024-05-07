package com.example.TUBConnect.repositories;

import com.example.TUBConnect.models.Autocarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutocarroRepository extends JpaRepository<Autocarro, Long> {
    List<Autocarro> findByRotaId(Long rotaId);

}
