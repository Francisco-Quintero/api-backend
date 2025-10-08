package com.example.api_backend.controllers;

import com.example.api_backend.entity.Campista;
import com.example.api_backend.services.CampistaService;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/campistas")
@CrossOrigin(origins = "*")
public class CampistaController {

    private final CampistaService campistaService;

    public CampistaController(CampistaService campistaService) {
        this.campistaService = campistaService;
    }

    @GetMapping
    public List<Campista> listarCampistas() {
        return campistaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Campista> obtenerPorId(@PathVariable UUID id) {
        return campistaService.buscarPorId(id);
    }

    @PostMapping
    public Campista crear(@RequestBody Campista campista) {
        return campistaService.guardar(campista);
    }

    @PutMapping("/{id}")
    public Campista actualizar(@PathVariable UUID id, @RequestBody Campista campista) {
        campista.setId(id);
        return campistaService.guardar(campista);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable UUID id) {
        campistaService.eliminar(id);
    }

    @GetMapping("/datos-basicos")
    public List<Map<String, Object>> obtenerDatosBasicos() {
        return campistaService.listarTodos().stream().map(c -> {
            Map<String, Object> data = new HashMap<>();
            data.put("nombre", c.getNombreCompleto());
            data.put("telefono", c.getTelefono());
            data.put("foto", c.getFotoUrl());
            return data;
        }).toList();
    }
}
