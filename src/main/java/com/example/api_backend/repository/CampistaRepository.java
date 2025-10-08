package com.example.api_backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_backend.entity.Campista;

public interface CampistaRepository extends JpaRepository<Campista, UUID> {
    List<Campista> findAllByOrderByNombreCompletoAsc();
}
