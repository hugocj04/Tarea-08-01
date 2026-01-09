package com.tarea801.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "estacion_id", foreignKey = @ForeignKey(name = "fk_bicicleta_estacion"))
    private Estacion estaEn;

    @OneToMany
    private Uso uso;

}
