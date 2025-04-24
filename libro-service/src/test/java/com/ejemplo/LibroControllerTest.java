package com.example.libroservice;

import com.example.libroservice.controller.LibroController;
import com.example.libroservice.model.Libro;
import com.example.libroservice.service.LibroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@WebFluxTest(LibroController.class)
public class LibroControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private LibroService libroService;

    @Test
    void testCrearLibro() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroService.crear(Mockito.any())).thenReturn(Mono.just(libro));

        webTestClient.post()
                .uri("/libros")
                .bodyValue(libro)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.titulo").isEqualTo("Clean Code");
    }

    @Test
    void testListarLibros() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroService.listar()).thenReturn(Flux.just(libro));

        webTestClient.get()
                .uri("/libros")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].titulo").isEqualTo("Clean Code");
    }

    @Test
    void testObtenerPorId() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroService.obtenerPorId("1")).thenReturn(Mono.just(libro));

        webTestClient.get()
                .uri("/libros/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.isbn").isEqualTo("123456");
    }

    @Test
    void testAsignarAutor() {
        Libro libro = new Libro("1", "Clean Code", "123456", "autor123");
        Mockito.when(libroService.asignarAutor("1", "autor123")).thenReturn(Mono.just(libro));

        webTestClient.put()
                .uri("/libros/1/autor")
                .bodyValue("autor123")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.autorId").isEqualTo("autor123");
    }
}
