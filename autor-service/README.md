# 👨‍💼 Autor Service

Microservicio para el registro y gestión de autores.

## 🚀 Endpoints

| Método | Endpoint        | Descripción              |
|--------|-----------------|--------------------------|
| POST   | `/autores`      | Crear un nuevo autor     |
| GET    | `/autores`      | Listar todos los autores |

## 🧪 Pruebas

- **Unitarias**: `SampleServiceTest`
- **Integración**: `SampleControllerTest` (WebTestClient)

## 🐳 Docker

```bash
docker build -t autor-service .
docker run -p 8082:8080 autor-service
```

## ⚙️ Actuator

- `/actuator/health`: Verifica el estado del microservicio
