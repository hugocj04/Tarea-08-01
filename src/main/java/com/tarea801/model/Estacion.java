package com.tarea801.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String nombre;
    public String coordenadas;
    public int capacidad;

    @OneToMany
    private Bicicleta bicicleta;

    @OneToMany
    private Uso uso;
}
