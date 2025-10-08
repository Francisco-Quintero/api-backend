package com.example.api_backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_backend.entity.Comida;

public interface ComidaRepository extends JpaRepository <Comida, UUID>{
    List<Comida> findByCampistaId(UUID campistaId);
}
