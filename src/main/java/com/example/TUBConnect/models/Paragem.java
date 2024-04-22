package com.example.TUBConnect.models;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table
public class Paragem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paragem_id;
    private String descricao;
    private Long distancia;
    private Double latitude;

    private Double longitude;


    public Paragem() {
    }

    public Paragem(Long paragem_id, String descricao, Long distancia, Double latitude, Double longitude) {
        this.paragem_id=paragem_id;
        this.descricao = descricao;
        this.distancia = distancia;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Paragem(String descricao, Long distancia, Double latitude, Double longitude) {
        this.descricao = descricao;
        this.distancia = distancia;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getParagem_id() {
        return paragem_id;
    }

    public void setParagem_id(Long paragem_id) {
        this.paragem_id = paragem_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getDistancia() {
        return distancia;
    }

    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
