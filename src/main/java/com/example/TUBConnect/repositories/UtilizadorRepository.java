package com.example.TUBConnect.repositories;

import com.example.TUBConnect.models.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
    @Query("SELECT u FROM Utilizador u WHERE u.email=?1")
    Optional<Utilizador> findUtilizadorByEmail(String email);

    Optional<Utilizador> findByEmailAndPassword(String email, String password);
}
