package com.example.api_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "campista")
public class Campista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "cedula", nullable = false, unique = true)
    private String cedula;

    @Column(name = "fecha_nacimiento", nullable = true)
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_expedicion")
    private LocalDate fechaExpedicionCedula;

    @Column(name = "foto")
    private String fotoUrl; // Guardaremos la URL del archivo en Supabase Storage

    @Transient
    private Integer edad;

    public Integer getEdad() {
        if (fechaNacimiento == null) return null;
        return LocalDate.now().getYear() - fechaNacimiento.getYear();

    }
}
