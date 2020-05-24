package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Vuelo;

import java.util.List;

public interface VueloService {
    List<Vuelo> findAll();
    Vuelo findById(Integer id);
    Vuelo save(Vuelo vuelo);
    Vuelo update(Vuelo vuelo);
    void delete(Integer id);
}
