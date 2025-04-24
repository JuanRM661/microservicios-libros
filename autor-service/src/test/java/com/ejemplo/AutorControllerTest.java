package com.example.autorservice;

import com.example.autorservice.controller.AutorController;
import com.example.autorservice.model.Autor;
import com.example.autorservice.service.AutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(AutorController.class)
public class AutorControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private AutorService autorService;

    @Test
    void testCrearAutor() {
        Autor autor = new Autor();
        autor.setId("1");
        autor.setNombre("Gabriel García Márquez");

        when(autorService.crear(autor)).thenReturn(Mono.just(autor));

        webClient.post().uri("/autores")
                .bodyValue(autor)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Autor.class)
                .isEqualTo(autor);
    }
}
