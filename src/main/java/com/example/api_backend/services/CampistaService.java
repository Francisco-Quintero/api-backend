package com.example.api_backend.services;

import com.example.api_backend.entity.Campista;
import com.example.api_backend.repository.CampistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampistaService {

    private final CampistaRepository campistaRepository;

    public CampistaService(CampistaRepository campistaRepository) {
        this.campistaRepository = campistaRepository;
    }

    public List<Campista> listarTodos() {
        return campistaRepository.findAllByOrderByNombreCompletoAsc();
    }

    public Optional<Campista> buscarPorId(UUID id) {
        return campistaRepository.findById(id);
    }

    public Campista guardar(Campista campista) {
        return campistaRepository.save(campista);
    }

    public void eliminar(UUID id) {
        campistaRepository.deleteById(id);
    }

    public List<Object[]> obtenerDatosBasicos() {
        return campistaRepository.findAll().stream()
                .map(c -> new Object[] { c.getNombreCompleto(), c.getTelefono(), c.getFotoUrl() })
                .toList();
    }
}
