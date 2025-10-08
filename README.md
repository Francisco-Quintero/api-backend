---

## 🏕️ Proyecto Backend — Sistema de Registro y Comidas de los Campistas

Este proyecto corresponde al **backend** del sistema de registro y control de campistas, desarrollado en **Spring Boot** y conectado a una base de datos **Supabase (PostgreSQL)**.
El propósito principal es gestionar la información de los campistas y el registro de sus comidas durante el evento, permitiendo futuras integraciones con aplicaciones móviles y frontends web.

### 🚀 Características principales

* **Gestión de campistas**: registro, consulta y administración de datos personales.
* **Registro de comidas**: permite confirmar asistencia a cada comida (desayuno, almuerzo, cena) con fecha y hora exacta.
* **Integración con Supabase**: conexión directa con una base de datos PostgreSQL alojada en Supabase.
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


## 📘 **Documentación de Endpoints — CampistaController**

**Base URL:**
`https://api-backend-ooz2.onrender.com/api/campistas`

**Descripción general:**
Este módulo gestiona los registros de campistas, permitiendo crear, consultar, actualizar y eliminar información.
Cada campista tiene información personal, identificación, fecha de nacimiento, y una foto almacenada como URL (por ejemplo, en Supabase Storage).

---

### 🧩 **1. Obtener todos los campistas**

**Método:** `GET`
**Endpoint:** `/api/campistas`

**Descripción:**
Devuelve una lista completa de todos los campistas almacenados en la base de datos.

**Ejemplo de respuesta (200 OK):**

```json
[
  {
    "id": "ccbf4899-b0e4-46db-b21a-593ae4149e77",
    "nombreCompleto": "Juan Pérez",
    "telefono": "3001234567",
    "cedula": "1012345678",
    "fechaNacimiento": "2002-05-18",
    "fechaExpedicionCedula": "2020-06-10",
    "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/juan.jpg",
    "edad": 23
  }
]
```

---

### 🔍 **2. Obtener campista por ID**

**Método:** `GET`
**Endpoint:** `/api/campistas/{id}`

**Descripción:**
Obtiene los datos de un campista específico según su identificador UUID.

**Parámetros de ruta:**

* `id` *(UUID)* — identificador único del campista.

**Ejemplo de solicitud:**

```
GET /api/campistas/ccbf4899-b0e4-46db-b21a-593ae4149e77
```

**Ejemplo de respuesta (200 OK):**

```json
{
  "id": "ccbf4899-b0e4-46db-b21a-593ae4149e77",
  "nombreCompleto": "Juan Pérez",
  "telefono": "3001234567",
  "cedula": "1012345678",
  "fechaNacimiento": "2002-05-18",
  "fechaExpedicionCedula": "2020-06-10",
  "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/juan.jpg",
  "edad": 23
}
```

---

### ➕ **3. Crear nuevo campista**

**Método:** `POST`
**Endpoint:** `/api/campistas`

**Descripción:**
Registra un nuevo campista.
El campo `id` es generado automáticamente (UUID).

**Cuerpo (JSON):**

```json
{
  "nombreCompleto": "Laura Martínez",
  "telefono": "3025558888",
  "cedula": "1034567890",
  "fechaNacimiento": "2003-09-15",
  "fechaExpedicionCedula": "2021-02-10",
  "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/laura.jpg"
}
```

**Ejemplo de respuesta (201 Created):**

```json
{
  "id": "4aefbdc5-dcb7-497b-a07f-3f5b3827b1e4",
  "nombreCompleto": "Laura Martínez",
  "telefono": "3025558888",
  "cedula": "1034567890",
  "fechaNacimiento": "2003-09-15",
  "fechaExpedicionCedula": "2021-02-10",
  "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/laura.jpg",
  "edad": 22
}
```

---

### ✏️ **4. Actualizar un campista existente**

**Método:** `PUT`
**Endpoint:** `/api/campistas/{id}`

**Descripción:**
Actualiza los datos de un campista existente.
El ID debe pasarse en la URL.

**Parámetros de ruta:**

* `id` *(UUID)* — identificador único del campista.

**Cuerpo (JSON):**

```json
{
  "nombreCompleto": "Laura Martínez Ochoa",
  "telefono": "3025559999",
  "cedula": "1034567890",
  "fechaNacimiento": "2003-09-15",
  "fechaExpedicionCedula": "2021-02-10",
  "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/laura-ochoa.jpg"
}
```

**Ejemplo de respuesta (200 OK):**

```json
{
  "id": "4aefbdc5-dcb7-497b-a07f-3f5b3827b1e4",
  "nombreCompleto": "Laura Martínez Ochoa",
  "telefono": "3025559999",
  "cedula": "1034567890",
  "fechaNacimiento": "2003-09-15",
  "fechaExpedicionCedula": "2021-02-10",
  "fotoUrl": "https://supabase.co/storage/v1/object/public/fotos/laura-ochoa.jpg",
  "edad": 22
}
```

---

### ❌ **5. Eliminar campista**

**Método:** `DELETE`
**Endpoint:** `/api/campistas/{id}`

**Descripción:**
Elimina definitivamente un registro de campista de la base de datos.

**Parámetros de ruta:**

* `id` *(UUID)* — identificador del campista.

**Ejemplo:**

```
DELETE /api/campistas/4aefbdc5-dcb7-497b-a07f-3f5b3827b1e4
```

**Respuesta (204 No Content):**

```
(no content)
```

---

### 📋 **6. Obtener datos básicos de campistas**

**Método:** `GET`
**Endpoint:** `/api/campistas/datos-basicos`

**Descripción:**
Devuelve solo los datos esenciales de cada campista (nombre, teléfono y URL de foto).
Ideal para mostrar listados rápidos, tarjetas o selecciones en el frontend.

**Ejemplo de respuesta (200 OK):**

```json
[
  {
    "nombre": "Juan Pérez",
    "telefono": "3001234567",
    "foto": "https://supabase.co/storage/v1/object/public/fotos/juan.jpg"
  },
  {
    "nombre": "Laura Martínez",
    "telefono": "3025558888",
    "foto": "https://supabase.co/storage/v1/object/public/fotos/laura.jpg"
  }
]
```

---

### 🧠 **Resumen general**

|  Método  | Endpoint                       | Descripción                           |
| :------: | :----------------------------- | :------------------------------------ |
|   `GET`  | `/api/campistas`               | Lista todos los campistas             |
|   `GET`  | `/api/campistas/{id}`          | Obtiene un campista por su ID         |
|  `POST`  | `/api/campistas`               | Crea un nuevo campista                |
|   `PUT`  | `/api/campistas/{id}`          | Actualiza un campista existente       |
| `DELETE` | `/api/campistas/{id}`          | Elimina un campista                   |
|   `GET`  | `/api/campistas/datos-basicos` | Devuelve solo nombre, teléfono y foto |

---

