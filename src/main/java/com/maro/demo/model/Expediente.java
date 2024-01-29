package com.maro.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Expediente {
    @Id private Long numExpediente;
    @Column
    private String actor;
    @Column
    private String demandado;
    @Column
    private String materia;
    @Column
    private String estado;
    @Column
    private String comentario;

}
