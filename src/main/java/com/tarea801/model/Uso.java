package com.tarea801.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double coste;

    @OneToMany
    private Usuario usuario;

    @ManyToOne
    private Bicicleta bicicleta;

    @ManyToOne
    private Estacion estacion;

}
