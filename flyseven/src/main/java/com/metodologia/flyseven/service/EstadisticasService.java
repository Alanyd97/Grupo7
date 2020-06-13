package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.model.dto.Distance;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by efalcon
 */
@Service
@NoArgsConstructor
public class EstadisticasService {

    private ViajeService viajeService;
    private RestTemplate restTemplate;

    @Autowired
    public EstadisticasService(ViajeService viajeService, RestTemplate restTemplate) {
        this.viajeService = viajeService;
        this.restTemplate = restTemplate;
    }

    /**
     * Distance between two or more cities
     * @param cities E.g: buenos aires|Olavarria|tandil
     * @return
     */
    protected int getDistanceBetweenCities(String cities) {
        try {
            Distance distance = restTemplate.getForObject("https://www.distancia.co/route.json?stops=" + cities, Distance.class);
            return distance.getDistance();
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Una de las ciudades proporcionadas no existe");
        }
    }

    /**
     * Search for cities in the Vuelos and in the escalas of those ones and sums the kms
     * @param viajeId of Viaje
     * @return traveled kms
     */
    public int getTraveledKmsByViaje(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        int distance = 0;
        for(Vuelo v: vuelos) {
            String cities = v.getOrigen().getCiudad();
            for (Vuelo escala : v.getEscalas()) {
                cities = cities + "|"+ escala.getOrigen().getCiudad() + "|" + escala.getDestino().getCiudad();
            }
            cities = cities + "|" + v.getDestino().getCiudad();
            distance += getDistanceBetweenCities(cities);
        }
        return distance;
    }

    private List<Vuelo> getVuelosByViaje(Integer viajeId) {
        Viaje viaje = viajeService.findById(viajeId);
        return viaje.getPlanes().stream()
                .filter(x -> x.getType().equals("Vuelo"))
                .map(x -> (Vuelo) x)
                .collect(Collectors.toList());
    }

    /**
     * Search for cities in the Vuelos and in the escalas of those ones
     * @param viajeId
     * @return Set of visited cities
     */
    public Set<String> getVisitedCitiesByViaje(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        Set<String> cities = new HashSet<>();
        for(Vuelo v: vuelos) {
            cities.add(v.getOrigen().getCiudad());
            for (Vuelo escala : v.getEscalas()) {
                cities.add(escala.getOrigen().getCiudad());
                cities.add(escala.getDestino().getCiudad());
            }
            cities.add(v.getDestino().getCiudad());
        }
        return cities;
    }

}
