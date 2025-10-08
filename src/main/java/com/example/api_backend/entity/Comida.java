package com.example.api_backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "comida")
public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private java.util.UUID id;

    @ManyToOne
    @JoinColumn(name = "campista_id", nullable = false)
    private Campista campista;

    @Column(name = "tipo_comida", nullable = false)
    private String tipoComida; // desayuno, almuerzo, cena

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "comio", nullable = false)
    private boolean comio;

}