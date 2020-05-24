package com.metodologia.flyseven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by efalcon
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @GetMapping
    public String hi() {
        return "hi";
    }
}
