package com.example.api_backend.controllers;

import com.example.api_backend.entity.Campista;
import com.example.api_backend.services.CampistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/campistas")
@CrossOrigin(origins = "*") // Permite pruebas desde cualquier frontend (puedes restringir luego)
public class CampistaController {

    private final CampistaService campistaService;

    public CampistaController(CampistaService campistaService) {
        this.campistaService = campistaService;
    }

    // 📋 GET: Listar todos los campistas
    @GetMapping
    public ResponseEntity<List<Campista>> listarCampistas() {
        List<Campista> campistas = campistaService.listarTodos();
        return ResponseEntity.ok(campistas);
    }

    // 🔍 GET: Buscar campista por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable String id) {
        Optional<Campista> campista = campistaService.obtenerPorId(id);

        return campista
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.status(404).body(Map.of("error", "Campista no encontrado con ID: " + id)));

    }

    // ➕ POST: Registrar nuevo campista
    @PostMapping
    public ResponseEntity<?> registrarCampista(@RequestBody Campista campista) {
        try {
            Campista nuevo = campistaService.guardar(campista);
            return ResponseEntity.status(201).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    // ✏️ PUT: Actualizar campista existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCampista(@PathVariable String id, @RequestBody Campista campista) {
        try {
            Campista actualizado = campistaService.actualizar(id, campista);
            return ResponseEntity.ok(actualizado);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    // 🗑️ DELETE: Eliminar campista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCampista(@PathVariable String id) {
        try {
            campistaService.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Campista eliminado correctamente"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @PatchMapping("/{id}/asistencia")
    public ResponseEntity<Campista> registrarAsistencia(
            @PathVariable String id,
            @RequestBody Map<String, Boolean> body) {

        boolean registroAsistencia = body.get("registroAsistencia");
        Campista campistaActualizado = campistaService.registrarAsistencia(id, registroAsistencia);
        return ResponseEntity.ok(campistaActualizado);
    }
}
