package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
        List<Viaje> all = viajeRepository.findAll();
        return all;
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
        Viaje one = viajeRepository.getOne(viaje.getIdViaje());
        if(Objects.nonNull(one)) {
            one.setNombre(viaje.getNombre());
            one.setDestino(viaje.getDestino());
            one.setVuelta(viaje.getVuelta());
            one.setIda(viaje.getIda());
            one.setVuelos(viaje.getPlanes());
            one.setDescripcion(viaje.getDescripcion());
            return viajeRepository.save(one);
        }
        throw new IllegalArgumentException("El id del viaje no existe");
    }

    @Override
    public void delete(Integer id) {
        viajeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer idViaje) {
        return viajeRepository.existsById(idViaje);
    }
}
