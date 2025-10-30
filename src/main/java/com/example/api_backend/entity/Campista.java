package com.example.api_backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name = "campistas")
public class Campista {

    @Id
    private String id; // UUID en texto (VARCHAR en MySQL)

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private Integer edad;

    private String eps;

    private String telefono;

    private String alergias;

    @Column(name = "tipo_campista")
    private String tipoCampista;

    @Column(name = "registro_asistencia")
    private Boolean registroAsistencia;

    @Column(name = "fecha_registro_asistencia")
    private LocalDateTime fechaRegistroAsistencia;
}
