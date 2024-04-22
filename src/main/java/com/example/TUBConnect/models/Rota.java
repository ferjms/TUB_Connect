package com.example.TUBConnect.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Rota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rota_id;




    @OneToMany(mappedBy = "rota") // Esta linha indica que uma rota pode ter muitos autocarros
    private List<Autocarro> autocarros;

    // Construtores, getters e setters

    // ... (os outros métodos permanecem inalterados)

    // Getters e setters para autocarros
    public List<Autocarro> getAutocarros() {
        return autocarros;
    }

    public void setAutocarros(List<Autocarro> autocarros) {
        this.autocarros = autocarros;
    }
}
