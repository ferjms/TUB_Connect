package com.example.TUBConnect.config;

import com.example.TUBConnect.models.Utilizador;
import com.example.TUBConnect.repositories.UtilizadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UtilizadorConfig {

    @Bean
    CommandLineRunner commandLineRunner(UtilizadorRepository repository){
        return args -> {
            Utilizador joao = new Utilizador(
                    "João",
                    "joao@example.com",
                    "joao123",
                    "cliente",
                    "Portuguesa",
                    "Português",
                    "913123359",
                    123456789L
            );
            Utilizador joaquim = new Utilizador(
                    "Joaquim",
                    "joaquim@example.com",
                    "joaquim132",
                    "turista",
                    "Inglesa",
                    "Inglês",
                    "9114141515",
                    123456789L
            );

            repository.saveAll(
                    List.of(joao,joaquim)
            );

        };
    }
}
