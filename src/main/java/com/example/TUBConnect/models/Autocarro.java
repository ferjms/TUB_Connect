package com.example.TUBConnect.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Autocarro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long autocarro_id;

    public Autocarro() {

    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    @ManyToOne
    @JoinColumn(name = "rota_id") // This column in Autocarro table should match the primary key of Rota
    private Rota rota;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "ativo")
    private boolean ativo;

    public Autocarro(Rota rota) {
        this.rota = rota;
    }


    public Autocarro(Rota rota, int capacidade, String matricula, boolean ativo) {
        this.rota = rota;
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

