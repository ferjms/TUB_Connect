package com.example.TUBConnect.Config;

import com.example.TUBConnect.models.utilizador;
import com.example.TUBConnect.repositories.utilizadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class utilizadorConfig {

    @Bean
    CommandLineRunner commandLineRunner(utilizadorRepository repository){
        return args -> {
            utilizador joao = new utilizador(
                    "João",
                    "joao@example.com",
                    "joao123",
                    "cliente",
                    "Portuguesa",
                    "Português",
                    "913123359",
                    123456789L
            );
            utilizador joaquim = new utilizador(
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
