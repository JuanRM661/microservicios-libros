# Sistema de Gestión de Libros - Microservicios

Este proyecto consiste en tres microservicios desarrollados con Spring Boot WebFlux:
- **libro-service**: gestiona libros.
- **autor-service**: gestiona autores.
- **gateway-service**: enruta solicitudes entre servicios.

## Tecnologías utilizadas
- Spring Boot 3 + WebFlux
- MongoDB
- Docker + Docker Compose
- GitHub Actions (CI/CD)
- JUnit, Mockito, WebTestClient

## Cómo ejecutar
1. Construye los jars: `mvn clean package` en cada servicio.
2. Ejecuta `docker-compose up --build`.

## Endpoints
- `POST /libros` - Crear libro
- `GET /libros` - Listar libros
- `GET /libros/{id}` - Obtener libro
- `PUT /libros/{id}/autor` - Asignar autor a libro
- `POST /autores` - Crear autor