package com.example.api_backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "campista_id", nullable = false)
    private UUID campistaId;

    @Column(name = "tipo_comida", nullable = false)
    private String tipoComida; // desayuno, almuerzo, cena

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "dia_comida", nullable = false)
    private String diaComida;

    @Column(name = "registrado_por")
    private String registradoPor; // nombre de la persona que registró la comida

    @Column(name = "comio", nullable = false)
    private boolean comio;
}
