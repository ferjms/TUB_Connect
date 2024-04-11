package com.example.TUBConnect.services;

import com.example.TUBConnect.models.utilizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.TUBConnect.repositories.utilizadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class utilizadorService {

    private final utilizadorRepository userRepository;

    @Autowired
    public utilizadorService(utilizadorRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<utilizador> listarUtilizadores(){
        return userRepository.findAll();

    }

    public static void addNewUser(utilizador user) {
        System.out.println(user);
    }

}
