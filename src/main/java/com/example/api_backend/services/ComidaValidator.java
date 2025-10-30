package com.example.api_backend.services;

import java.time.*;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.api_backend.entity.Comida;
import com.example.api_backend.repository.ComidaRepository;

@Service
public class ComidaValidator {

    private final ComidaRepository comidaRepository;

    public ComidaValidator(ComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    /**
     * 
     * Verifica que no exista ya un registro del mismo tipo de comida
     * para el mismo campista en el día de hoy.
     */
    public void validarRegistroUnicoDiario(Comida comida) {
        UUID campistaId = comida.getCampistaId();
        String tipoComidaNormalizado = comida.getTipoComida(); // Ya normalizado

        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Optional<Comida> comidaExistente = comidaRepository.findByCampistaIdAndTipoComidaAndFechaRegistroBetween(
            campistaId,
            tipoComidaNormalizado,
            startOfDay,
            endOfDay
        );

        if (comidaExistente.isPresent()) {
            throw new IllegalStateException(
                "El campista con ID " + campistaId + " ya registró un(a) **" + tipoComidaNormalizado.toUpperCase() + "** el día de hoy."
            );
        }
    }
}