package com.example.TUBConnect.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "viagem")
public class Viagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long viagemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rota_id", nullable = false)
    private Rota rota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilizador_id")
    private Utilizador utilizador;

    private String designacao;

    // Construtores, getters e setters
    public Viagem() {}

    public Viagem(long viagemId, Rota rota, Utilizador utilizador, String designacao) {
        this.viagemId = viagemId;
        this.rota = rota;
        this.utilizador = utilizador;
        this.designacao = designacao;
    }

    public long getViagemId() {
        return viagemId;
    }

    public void setViagem_id(long viagemId) {
        this.viagemId = viagemId;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
