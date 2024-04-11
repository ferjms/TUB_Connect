package com.example.TUBConnect.models;

import jakarta.persistence.*;
import org.springframework.data.web.PageableDefault;

import java.io.Serializable;



@Entity(name="utilizador")
@Table(name="utilizador")
public class utilizador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utilizador_id;
    private String nome;
    private String email;
    private String password;
    private String tipo;
    private String nacionalidade;
    private String idiomaPreferido;
    private String telefone;
    private long nif;

    public utilizador() {

    }

    public utilizador(long utilizador_id, String nome, String email, String password, String tipo, String nacionalidade, String idiomaPreferido, String telefone, long nif) {
        this.utilizador_id = utilizador_id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.nacionalidade = nacionalidade;
        this.idiomaPreferido = idiomaPreferido;
        this.telefone = telefone;
        this.nif = nif;
    }

    public utilizador(String nome, String email, String password, String tipo, String nacionalidade, String idiomaPreferido, String telefone, long nif) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.nacionalidade = nacionalidade;
        this.idiomaPreferido = idiomaPreferido;
        this.telefone = telefone;
        this.nif = nif;
    }

    public long getUtilizador_id() {
        return utilizador_id;
    }

    public void setUtilizador_id(long utilizador_id) {
        this.utilizador_id = utilizador_id;
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

    @Override
    public String toString() {
        return "utilizador{" +
                "utilizador_id=" + utilizador_id +
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
