package com.metodologia.flyseven.controller;

import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by efalcon
 */
@RestController
@RequestMapping("/vuelo")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<Vuelo> findAll() {
        return vueloService.findAll();
    }

    @GetMapping("/id")
    public Vuelo findById(@RequestParam("id") Integer id) {
        return vueloService.findById(id);
    }

    @PostMapping
    public Vuelo save(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }

    @PutMapping
    public Vuelo update(@RequestBody Vuelo vuelo) {
        return vueloService.update(vuelo);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Integer id) {
        vueloService.delete(id);
    }
}

