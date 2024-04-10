package com.example.TUBConnect.models;

import jakarta.persistence.*;
import org.springframework.data.web.PageableDefault;

import java.io.Serializable;


@Table(name="utilizador")
@Entity(name="utilizador")
public class utilizador implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utilizador_id;
    private String nome;
    private String email;
    private String password;
    private String tipo;
    private String nacionalidade;
    private String idiomaPreferido;
    private String telefone;
    private long nif;
}
