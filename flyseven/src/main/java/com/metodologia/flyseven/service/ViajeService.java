package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Viaje;

import java.util.List;

/**
 * Created by efalcon
 */
public interface ViajeService {
    List<Viaje> findAll();
    Viaje findById(Integer id);
    Viaje save(Viaje viaje);
    Viaje update(Viaje viaje);
    void delete(Integer id);
}
