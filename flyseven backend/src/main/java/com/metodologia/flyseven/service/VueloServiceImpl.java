package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by efalcon
 */
@Service
public class VueloServiceImpl implements VueloService{

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Override
    public Vuelo findById(Integer id) {
        return vueloRepository.findById(id).orElse(new Vuelo());
    }

    @Override
    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo update(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public void delete(Integer id) {
        vueloRepository.deleteById(id);
    }
}
