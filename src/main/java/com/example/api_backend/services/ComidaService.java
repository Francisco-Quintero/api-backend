package com.example.api_backend.services;

import java.time.*;
import java.util.*;

import org.springframework.stereotype.Service;
import com.example.api_backend.entity.Comida;
import com.example.api_backend.repository.ComidaRepository;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;
    private final ComidaValidator comidaValidator;

    public ComidaService(ComidaRepository comidaRepository, ComidaValidator comidaValidator) {
        this.comidaRepository = comidaRepository;
        this.comidaValidator = comidaValidator;
    }

    public List<Comida> listarTodas() {
        return comidaRepository.findAll();
    }

    public List<Comida> listarPorCampista(String campistaId) {
        return comidaRepository.findAll()
                .stream()
                .filter(c -> c.getCampistaId().equals(campistaId))
                .toList();
    }

    public Comida registrar(Comida comida) {
        comidaValidator.validarRegistroUnicoDiario(comida);
        if (comida.getId() == null) {
            comida.setId(UUID.randomUUID().toString());
        }
        comida.setFechaRegistro(LocalDateTime.now());
        return comidaRepository.save(comida);
    }
}
