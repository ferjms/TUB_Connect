package com.example.TUBConnect.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "viagem")
public class Viagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long viagem_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rota_id", nullable = false)
    private Rota rota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    private String designacao;

    // Construtores, getters e setters
    public Viagem() {}

    public Viagem(long viagem_id, Rota rota, Utilizador utilizador, String designacao) {
        this.viagem_id = viagem_id;
        this.rota = rota;
        this.utilizador = utilizador;
        this.designacao = designacao;
    }

    public long getViagem_id() {
        return viagem_id;
    }

    public void setViagem_id(long viagem_id) {
        this.viagem_id = viagem_id;
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
