package com.example.TUBConnect.models;

import jakarta.persistence.*;

@Entity
@Table(name = "autocarro")
public class Autocarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autocarro_id")
    private Long autocarroId;

    private Boolean ativo;

    private Integer capacidade;

    private String matricula;

    @Column(name = "rota_id")
    private Long rotaId;

    // Getters e setters atualizados
    public Long getRotaId() {
        return rotaId;
    }

    public void setRotaId(Long rotaId) {
        this.rotaId = rotaId;
    }

    // Getters e setters
    public Long getAutocarroId() {
        return autocarroId;
    }

    public void setAutocarroId(Long autocarroId) {
        this.autocarroId = autocarroId;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
