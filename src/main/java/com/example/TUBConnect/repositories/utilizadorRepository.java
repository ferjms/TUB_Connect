package com.example.TUBConnect.repositories;



import com.example.TUBConnect.models.utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface utilizadorRepository extends JpaRepository<utilizador,Long> {


}
