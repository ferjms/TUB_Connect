package com.example.TUBConnect.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "passe")
public class Passe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passe_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilizador_id", referencedColumnName = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rota_id", nullable = false)
    private Rota rota;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPasse tipo;

    private Date data_compra;
    private double preco;
    private Date validade;
    private boolean estado;



    // Enumeração interna para tipos de passe
    public enum TipoPasse {
        ESTUDANTE,
        REFORMADO,
        JOVEM_MUNICIPE,
        FUNCIONARIO,
        PCD // Pessoa com Deficiência
    }

    // Construtores, getters e setters
    public Passe() {}

    public Passe(long passe_id, Utilizador utilizador, Rota rota, TipoPasse tipo, Date data_compra, double preco, Date validade, boolean estado) {
        this.passe_id = passe_id;
        this.utilizador = utilizador;
        this.rota = rota;
        this.tipo = tipo;
        this.data_compra = data_compra;
        this.preco = preco;
        this.validade = validade;
        this.estado = estado;
    }

    public long getPasse_id() {
        return passe_id;
    }

    public void setPasse_id(long passe_id) {
        this.passe_id = passe_id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public TipoPasse getTipo() {
        return tipo;
    }

    public void setTipo(TipoPasse tipo) {
        this.tipo = tipo;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}