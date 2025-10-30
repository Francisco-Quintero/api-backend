package com.example.api_backend.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api_backend.entity.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, UUID> {
    List<Comida> findByCampistaId(UUID campistaId);

    Optional<Comida> findByCampistaIdAndTipoComidaAndFechaRegistroBetween(
        UUID campistaId, 
        String tipoComida, 
        LocalDateTime startOfDay, 
        LocalDateTime endOfDay
    );
}
