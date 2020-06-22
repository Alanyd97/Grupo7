package com.metodologia.flyseven.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by efalcon
 */
@Data
public class Estadisticas {
    private Integer cantidadDeViajes;
    private Integer cantidadDeKmsRecorridos;
    private Map<String, Integer> ciudadesVisitadas;
    private Map<String, Integer> paisesVisitados;
    private Long cantidadHorasDeVuelo;
    private Double huellaDeCarbono;
}
