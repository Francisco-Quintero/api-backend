package com.example.api_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "comidas")
public class Comida {

    @Id
    private String id; // UUID generado manualmente o desde el servicio

    @Column(name = "campista_id", nullable = false)
    private String campistaId; // Ya no se usa relación @ManyToOne directa

    @Column(name = "tipo_comida", nullable = false)
    private String tipoComida; // desayuno, almuerzo, cena

    @Column(name = "dia_Comida", nullable = false)
    private String diaComida; // Viernes, Sábado, Domingo, Lunes

    @Column(name = "registrado_por")
    private String registradoPor;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
