package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by efalcon
 */
@Component
public class ViajeServiceImpl implements ViajeService {

    private ViajeRepository viajeRepository;

    @Autowired
    public ViajeServiceImpl(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> findAll() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje findById(Integer id) {
        return viajeRepository.findById(id).orElse(new Viaje());
    }

    @Override
    public Viaje save(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public Viaje update(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public void delete(Integer id) {
        viajeRepository.deleteById(id);
    }
}
