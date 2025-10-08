---

## 🏕️ Proyecto Backend — Sistema de Registro y Comidas de los Campistas

Este proyecto corresponde al **backend** del sistema de registro y control de campistas, desarrollado en **Spring Boot** y conectado a una base de datos **Supabase (PostgreSQL)**.
El propósito principal es gestionar la información de los campistas y el registro de sus comidas durante el evento, permitiendo futuras integraciones con aplicaciones móviles y frontends web.

### 🚀 Características principales

* **Gestión de campistas**: registro, consulta y administración de datos personales.
* **Registro de comidas**: permite confirmar asistencia a cada comida (desayuno, almuerzo, cena) con fecha y hora exacta.
* **Integración con Supabase**: conexión directa con una base de datos PostgreSQL alojada en Supabase.
* **Despliegue en Render**: API pública accesible desde aplicaciones Flutter o React.
* **UUID autogenerado**: cada campista se identifica de forma única con un UUID generado en la base de datos.
* **Edad calculada dinámicamente**: la edad del campista se determina a partir de su fecha de nacimiento.

### 🧩 Tecnologías utilizadas

* **Java 22**
* **Spring Boot**
* **Gradle**
* **PostgreSQL (Supabase)**

### 📡 Endpoints principales

| Método   | Endpoint          | Descripción                                        |
| -------- | ----------------- | -------------------------------------------------- |
| `GET`    | `/campistas`      | Obtiene todos los campistas registrados            |
| `GET`    | `/campistas/{id}` | Consulta la información de un campista por su UUID |
| `POST`   | `/campistas`      | Registra un nuevo campista                         |
| `PUT`    | `/campistas/{id}` | Actualiza la información de un campista            |
| `DELETE` | `/campistas/{id}` | Elimina un campista del sistema                    |
