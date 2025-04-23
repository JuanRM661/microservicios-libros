package com.ejemplo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;

@WebFluxTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testSaludo() {
        webClient.get().uri("/saludo")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hola Mundo");
    }
}
