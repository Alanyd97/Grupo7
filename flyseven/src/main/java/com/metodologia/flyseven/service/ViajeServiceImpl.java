package com.metodologia.flyseven.service;

import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.model.Vuelo;
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
        List<Viaje> all = viajeRepository.findAll();
        all.forEach(viaje -> {
            List<Vuelo> vuelos = viaje.getVuelos();
            if(!vuelos.isEmpty()) {
                viaje.setOrigen(vuelos.get(0).getOrigen().getPais());
                viaje.setDestino(vuelos.get(vuelos.size() - 1).getDestino().getPais());
                viaje.setIda(vuelos.get(0).getInicio());
                viaje.setVuelta(vuelos.get(vuelos.size() - 1).getFin());
            }
        });
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
        return viajeRepository.save(viaje);
    }

    @Override
    public void delete(Integer id) {
        viajeRepository.deleteById(id);
    }
}
