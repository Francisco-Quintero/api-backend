package com.example.api_backend.repository;

import com.example.api_backend.entity.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ComidaRepository extends JpaRepository<Comida, String> {

    @Query("""
        SELECT c FROM Comida c 
        WHERE c.campistaId = :campistaId 
        AND c.tipoComida = :tipoComida 
        AND c.fechaRegistro BETWEEN :inicio AND :fin
    """)
    Optional<Comida> findByCampistaIdAndTipoComidaAndFechaRegistroBetween(
        String campistaId,
        String tipoComida,
        LocalDateTime inicio,
        LocalDateTime fin
    );
}

