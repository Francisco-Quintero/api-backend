package com.example.api_backend.services;

import com.example.api_backend.entity.Campista;
import com.example.api_backend.entity.Comida;
import com.example.api_backend.repository.CampistaRepository;
import com.example.api_backend.repository.ComidaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;
    private final ComidaValidator comidaValidator;
    private final CampistaRepository campistaRepository;

    public ComidaService(ComidaRepository comidaRepository, ComidaValidator comidaValidator, CampistaRepository campistaRepository) {
        this.comidaRepository = comidaRepository;
        this.comidaValidator = comidaValidator;
        this.campistaRepository = campistaRepository;
    }

    public List<Comida> listarTodas() {
        return comidaRepository.findAll();
    }

    public List<Comida> listarPorCampista(UUID campistaId) {
        return comidaRepository.findByCampistaId(campistaId);
    }

    public Comida registrar(Comida comida) {
        // Normalizar tipo_comida a minúsculas para cumplir con el CHECK de la BD
        if (comida.getTipoComida() != null) {
            comida.setTipoComida(comida.getTipoComida().toLowerCase());
        }

        // Fecha actual si no se envía
        if (comida.getFechaRegistro() == null) {
            comida.setFechaRegistro(LocalDateTime.now());
        }

        // Asociar campista si solo se envía el ID
        if (comida.getCampistaId() == null && comida.getCampistaId() != null) {
            Campista campista = campistaRepository.findById(comida.getCampistaId())
                    .orElseThrow(() -> new RuntimeException("Campista no encontrado"));
            comida.setCampistaId(campista.getId());
        }

        comidaValidator.validarRegistroUnicoDiario(comida);

        return comidaRepository.save(comida);
    }
}
