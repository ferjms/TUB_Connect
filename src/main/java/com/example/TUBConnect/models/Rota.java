package com.example.TUBConnect.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rota")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rota_id")
    private Long rotaId;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String origem;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private int coroa;

    public int getCoroa() {
        return coroa;
    }

    public void setCoroa(int coroa) {
        this.coroa = coroa;
    }
    // Getters e setters
    public Long getId() {
        return rotaId;
    }

    public void setId(Long rotaId) {
        this.rotaId = rotaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
