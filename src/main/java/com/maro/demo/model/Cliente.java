package com.maro.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private String causa;
}
