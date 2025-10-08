package com.example.api_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "API conectada correctamente 🚀 YA TENEMOS CONEXION CON SUPABASE";
    }
}