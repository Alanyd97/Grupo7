package com.metodologia.flyseven.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by efalcon
 */
@Entity
@Data
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAeropuerto;

    private String nombre;

    private String ciudad;

    private String pais;

    public static Aeropuerto fromId(Integer aeropuertoId) {
        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.idAeropuerto = aeropuertoId;
        return aeropuerto;
    }
}
