package com.metodologia.flyseven.controller;

import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by efalcon
 */
@RestController
@RequestMapping("viaje")
public class ViajeController {
    
    private ViajeService viajeService;

    @Autowired
    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<Viaje> findAll() {
        return viajeService.findAll();
    }

    @GetMapping("/id")
    public Viaje findById(@RequestParam("id") Integer id) {
        return viajeService.findById(id);
    }

    @PostMapping
    public Viaje save(@RequestBody Viaje Viaje) {
        return viajeService.save(Viaje);
    }

    @PutMapping
    public Viaje update(@RequestBody Viaje Viaje) {
        return viajeService.update(Viaje);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Integer id) {
        viajeService.delete(id);
    }
}
