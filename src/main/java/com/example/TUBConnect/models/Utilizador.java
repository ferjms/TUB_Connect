package com.example.TUBConnect.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilizador")
public class Utilizador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilizador_id")
    private long utilizadorId;
    private String nome;
    private String email;
    private String password;
    private String tipo;
    private String nacionalidade;
    @Column(name = "idioma_preferido")
    private String idiomaPreferido;

    private String telefone;
    private long nif;

    // Construtores, getters e setters atualizados para usar utilizadorId
    public Utilizador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getIdiomaPreferido() {
        return idiomaPreferido;
    }

    public void setIdiomaPreferido(String idiomaPreferido) {
        this.idiomaPreferido = idiomaPreferido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public Utilizador(long utilizadorId, String nome, String email, String password, String tipo, String nacionalidade, String idiomaPreferido, String telefone, long nif) {
        this.utilizadorId = utilizadorId;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.nacionalidade = nacionalidade;
        this.idiomaPreferido = idiomaPreferido;
        this.telefone = telefone;
        this.nif = nif;
    }

    public Utilizador(String nome, String email, String password, String tipo, String nacionalidade, String idiomaPreferido, String telefone, long nif) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.nacionalidade = nacionalidade;
        this.idiomaPreferido = idiomaPreferido;
        this.telefone = telefone;
        this.nif = nif;
    }

    public long getUtilizadorId() {  // Nome do método atualizado
        return utilizadorId;
    }

    public void setUtilizadorId(long utilizadorId) {  // Nome do método atualizado
        this.utilizadorId = utilizadorId;
    }

    // Outros getters e setters...

    @Override
    public String toString() {
        return "Utilizador{" +
                "utilizadorId=" + utilizadorId +  // Atualizado para utilizadorId
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idiomaPreferido='" + idiomaPreferido + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nif=" + nif +
                '}';
    }
}
