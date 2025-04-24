
# 📚 Sistema de Gestión de Libros - Proyecto Integrador

Este proyecto es una implementación de un sistema distribuido utilizando arquitectura de microservicios. Permite registrar, consultar y administrar libros y autores, empleando tecnologías modernas como Spring Boot, WebFlux, MongoDB, Docker, y prácticas DevOps como CI/CD y pruebas automatizadas.

---

## 🔧 Tecnologías Utilizadas

- **Spring Boot 3**
- **Spring WebFlux**
- **MongoDB**
- **Spring Cloud Gateway**
- **Spring Cloud Netflix Eureka**
- **Spring Boot Actuator**
- **Docker & Docker Compose**
- **GitHub Actions**
- **JUnit 5, Mockito, WebTestClient**

---

## 🧱 Arquitectura del Proyecto

El sistema está compuesto por tres microservicios principales:

- **libro-service**: Maneja el CRUD de libros.
- **autor-service**: Administra autores y permite asociarlos a libros.
- **gateway-service**: Enruta las peticiones a los microservicios correspondientes (API Gateway).

Además, se puede incluir **Eureka Server** para descubrimiento de servicios.

---

## ⚙️ Funcionalidades Principales

### libro-service
- `POST /libros`: Crear un libro
- `GET /libros`: Listar todos los libros
- `GET /libros/{id}`: Buscar libro por ID
- `PUT /libros/{id}/autor`: Asignar un autor a un libro

### autor-service
- `POST /autores`: Crear un autor
- `GET /autores`: Listar todos los autores

### gateway-service
- Redirige las solicitudes a los servicios correspondientes según el path

---

## 🧪 Pruebas Automatizadas

Cada microservicio incluye:

- **Pruebas Unitarias** con Mockito
- **Pruebas de Integración** usando WebTestClient
- Los tests están organizados por capas: `controller`, `service`, y `repository`

---

## 📦 Contenerización con Docker

Cada microservicio incluye su propio `Dockerfile` y el proyecto cuenta con un archivo `docker-compose.yml` que:

- Levanta los tres microservicios
- Levanta instancias de MongoDB para cada servicio
- Conecta todo en una red común

### Comando para ejecutar:
```bash
docker-compose up --build
```

---

## 🔄 CI/CD con GitHub Actions

Se incluye un archivo `.github/workflows/test.yml` que:

- Configura Java 17
- Compila el proyecto
- Ejecuta pruebas automatizadas
- Valida el correcto funcionamiento del proyecto en cada push/pull request

---

## 📈 Monitorización

Todos los microservicios exponen el endpoint:

```
/actuator/health
```

A través del cual puede monitorearse el estado de cada microservicio.

---

## 🔐 Seguridad

Se puede extender el proyecto implementando autenticación JWT en alguno de los microservicios (por ejemplo, en el gateway).

---

## 🗂 Estructura del Proyecto

```
/microservicios-libros
├── autor-service
│   ├── src/
│   └── Dockerfile
├── libro-service
│   ├── src/
│   └── Dockerfile
├── gateway-service
│   ├── src/
│   └── Dockerfile
├── docker-compose.yml
├── .github/
│   └── workflows/test.yml
└── README.md
```

---

## 🚀 Cómo Ejecutar Localmente

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/tuusuario/microservicios-libros.git
   cd microservicios-libros
   ```

2. Ejecutar los microservicios con Docker Compose:
   ```bash
   docker-compose up --build
   ```

3. Acceder a los endpoints a través del gateway (por ejemplo):
   - `http://localhost:8080/libros`
   - `http://localhost:8080/autores`

---


## ✅ Estado del Proyecto

✔ Microservicios funcionales  
✔ Pruebas automatizadas implementadas  
✔ Pipeline de CI/CD funcionando  
✔ Despliegue local con Docker  
✔ Documentación completa  

---

## 🧑‍💻 Autor

Juan Esteban Rodríguez Murillo.
```
