package com.metodologia.flyseven.dtos;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by efalcon
 */
public class VueloDTO {

    private Integer idVuelo;

    private String aerolinea;

    private String aeronave;

    private String asiento;

    private String clase;

    private Integer codReserva;

    private Time duracion;

    private Float distancia;

    private Integer puerta;

    private LocalDateTime inicio;

    private LocalDateTime fin;

    private Integer idUsuario;

    private Integer idAeropuertoOrigen;

    private Integer idAeropuertoDestino;

    private List<Integer> escalaIds;
}
