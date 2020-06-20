package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Estadisticas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by efalcon
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadisticasServiceTest {

    @Autowired
    ViajeService viajeService;

    @Autowired
    EstadisticasService estadisticasService;

    @Before
    public void init() {
    }

    @Test
    public void calculateDistanceBetweenTwoCitiesTest() {
        int distanceBetweenCities = estadisticasService.getDistanceBetweenCities("Tandil|Olavarria");
        assertEquals(distanceBetweenCities, 114);
    }

    @Test
    public void calculateKmsByViajeTest() {
        int traveledKmsByViaje = estadisticasService.getTraveledKmsByViaje(1);
        assertEquals(traveledKmsByViaje, 130);
    }

    @Test
    public void calculateVisitedCitiesTest() {
        Set<String> visitedCitiesByViaje = estadisticasService.getVisitedCitiesByViaje(1);
        assertTrue(visitedCitiesByViaje.containsAll(Arrays.asList("Olavarria", "Tandil", "Azul")));
    }

    @Test
    public void getVisitedCounteriesTest() {
        Set<String> visitedCountriesByViaje = estadisticasService.getVisitedCountriesByViaje(1);
        assertTrue(visitedCountriesByViaje.contains("Argentina"));
    }

    @Test
    public void getAllEstadisticas() {
        Estadisticas allEstadisticasByUserId = this.estadisticasService.getAllEstadisticasByUserId(1);
        assertNotNull(allEstadisticasByUserId);
    }
}
