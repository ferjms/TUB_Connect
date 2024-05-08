package com.example.TUBConnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viagem_id")
    private Long viagemId;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    private Double preco;

    @Column(name = "utilizador_id")
    private Long utilizadorId;

    @Column(name = "rota_id")
    private Long rotaId;

    private Boolean estado;

    private String designacao;

    @Column(name = "coroa", nullable = false)
    private Integer coroa;  // Armazena o valor numérico da enumeração

    public Long getViagemId() {
        return viagemId;
    }

    public void setViagemId(Long viagemId) {
        this.viagemId = viagemId;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(Long utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public Long getRotaId() {
        return rotaId;
    }

    public void setRotaId(Long rotaId) {
        this.rotaId = rotaId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Integer getCoroa() {
        return coroa;
    }

    public void setCoroa(Coroa coroa) {
        this.coroa = coroa.getCoroa();  // Converte a enumeração para o valor inteiro correspondente
    }

    public enum Coroa {
        UM(1, 10.0),
        DOIS(2, 20.0);

        private final int coroa;
        private final double preco;

        Coroa(int coroa, double preco) {
            this.coroa = coroa;
            this.preco = preco;
        }

        public int getCoroa() {
            return this.coroa;
        }

        public double getPreco() {
            return this.preco;
        }
    }
}
