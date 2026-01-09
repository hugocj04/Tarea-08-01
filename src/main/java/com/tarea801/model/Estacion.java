package com.tarea801.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String nombre;
    public String coordenadas;
    public int capacidad;

    @OneToMany(mappedBy = "estaEn")
    @Builder.Default
    private List<Bicicleta> bicicletas = new ArrayList<>();

    @OneToMany
    private Uso uso;

    // Cuando una relacion sea bidireccional, hay que crear estos metodos en la clase OneToMany o en alguna de las dos ManyToMany

    public void addBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        bicicleta.setEstaEn(this);
    }

    public void removeBicicleta(Bicicleta bicicleta) {
        bicicletas.remove(bicicleta);
        bicicleta.setEstaEn(null);
    }
}
