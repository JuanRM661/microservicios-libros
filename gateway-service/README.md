# 🌐 Gateway Service

API Gateway para enrutar solicitudes a los microservicios `libro` y `autor`.

## ⚙️ Configuración

Este servicio enruta peticiones hacia:
- `libro-service` en `/libros/**`
- `autor-service` en `/autores/**`

## 🐳 Docker

```bash
docker build -t gateway-service .
docker run -p 8080:8080 gateway-service
```

## 🔐 Seguridad

JWT puede ser implementado para proteger rutas específicas.

## ⚙️ Actuator

- `/actuator/health`: Verifica el estado del gateway
