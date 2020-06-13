package com.metodologia.flyseven.controller;

import com.metodologia.flyseven.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by efalcon
 */
@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    final EstadisticasService estadisticasService;

    @Autowired
    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping("/kilometros-recorridos/{viajeId}")
    public int getTraveledKmsByViaje(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getTraveledKmsByViaje(id);
    }

    @GetMapping("/ciudades-visitadas/{viajeId}")
    public Set<String> getVisitedCities(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getVisitedCitiesByViaje(id);
    }

    @GetMapping("/huella-carbono/{viajeId}")
    public Double getHuellaCarbono(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getHuellaCarbono(id);
    }
}
