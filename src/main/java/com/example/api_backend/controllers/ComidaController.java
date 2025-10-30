package com.example.api_backend.controllers;

import com.example.api_backend.entity.Comida;
import com.example.api_backend.services.ComidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comidas")
@CrossOrigin(origins = "*")
public class ComidaController {

    private final ComidaService comidaService;

    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping
    public List<Comida> listarTodas() {
        return comidaService.listarTodas();
    }

    @GetMapping("/campista/{id}")
    public List<Comida> listarPorCampista(@PathVariable String id) {
        return comidaService.listarPorCampista(id);
    }

    @PostMapping
    public Comida registrar(@RequestBody Comida comida) {
        return comidaService.registrar(comida);
    }
}

