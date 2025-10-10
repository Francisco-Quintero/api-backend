package com.example.api_backend.services;

import com.example.api_backend.entity.Comida;
import com.example.api_backend.repository.ComidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;

    public ComidaService(ComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    public List<Comida> listarTodas() {
        return comidaRepository.findAll();
    }

    public List<Comida> listarPorCampista(UUID campistaId) {
        return comidaRepository.findByCampistaId(campistaId);
    }

    public Comida registrar(Comida comida) {
        comida.setTipoComida(comida.getTipoComida().toLowerCase());
        comida.setFechaRegistro(java.time.LocalDateTime.now());
        return comidaRepository.save(comida);
    }
}
