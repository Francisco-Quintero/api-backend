package com.example.api_backend.services;

import com.example.api_backend.entity.Campista;
import com.example.api_backend.repository.CampistaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CampistaService {

    private final CampistaRepository campistaRepository;

    public CampistaService(CampistaRepository campistaRepository) {
        this.campistaRepository = campistaRepository;
    }

    public List<Campista> listarTodos() {
        return campistaRepository.findAll();
    }

    public Optional<Campista> obtenerPorId(String id) {
        return campistaRepository.findById(id);
    }

    public Campista guardar(Campista campista) {
        if (campista.getId() == null || campista.getId().isEmpty()) {
            campista.setId(UUID.randomUUID().toString());
        }
        return campistaRepository.save(campista);
    }

    public Campista actualizar(String id, Campista campistaActualizado) {
        Campista campista = campistaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Campista no encontrado con ID: " + id));

        campista.setTipoDocumento(campistaActualizado.getTipoDocumento());
        campista.setNumeroDocumento(campistaActualizado.getNumeroDocumento());
        campista.setNombreCompleto(campistaActualizado.getNombreCompleto());
        campista.setFechaNacimiento(campistaActualizado.getFechaNacimiento());
        campista.setEdad(campistaActualizado.getEdad());
        campista.setEps(campistaActualizado.getEps());
        campista.setTelefono(campistaActualizado.getTelefono());
        campista.setAlergias(campistaActualizado.getAlergias());
        campista.setTipoCampista(campistaActualizado.getTipoCampista());
        campista.setRegistroAsistencia(campistaActualizado.getRegistroAsistencia());
        campista.setFechaRegistroAsistencia(campistaActualizado.getFechaRegistroAsistencia());

        return campistaRepository.save(campista);
    }

    public void eliminar(String id) {
        if (!campistaRepository.existsById(id)) {
            throw new NoSuchElementException("Campista no encontrado con ID: " + id);
        }
        campistaRepository.deleteById(id);
    }
}
