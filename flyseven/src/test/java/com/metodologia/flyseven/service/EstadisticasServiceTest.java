package com.metodologia.flyseven.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void calculateVisitedCities() {
        Set<String> visitedCitiesByViaje = estadisticasService.getVisitedCitiesByViaje(1);
        assertTrue(visitedCitiesByViaje.containsAll(Arrays.asList("Olavarria", "Tandil", "Azul")));
    }
}
