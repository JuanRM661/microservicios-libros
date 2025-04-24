# 📘 Libro Service

Microservicio encargado de la gestión de libros.

## 🚀 Endpoints

| Método | Endpoint                | Descripción                 |
|--------|-------------------------|-----------------------------|
| POST   | `/libros`               | Crear un nuevo libro        |
| GET    | `/libros`               | Listar todos los libros     |
| GET    | `/libros/{id}`          | Obtener libro por ID        |
| PUT    | `/libros/{id}/autor`    | Asignar autor a un libro    |

## 🧪 Pruebas

- **Unitarias**: `LibroServiceTest`
- **Integración**: `LibroControllerTest` (WebTestClient)

## 🐳 Docker

```bash
docker build -t libro-service .
docker run -p 8081:8080 libro-service
```

## ⚙️ Actuator

- `/actuator/health`: Verifica el estado del microservicio
