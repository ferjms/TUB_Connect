package com.example.TUBConnect.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Autocarro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long autocarro_id;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "ativo")
    private boolean ativo;

    public Autocarro() {
    }

    public Autocarro(int capacidade, String matricula, boolean ativo) {
        this.capacidade = capacidade;
        this.matricula = matricula;
        this.ativo = ativo;
    }

    public long getAutocarroId() {
        return autocarro_id;
    }

    public void setAutocarroId(long autocarro_id) {
        this.autocarro_id = autocarro_id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

