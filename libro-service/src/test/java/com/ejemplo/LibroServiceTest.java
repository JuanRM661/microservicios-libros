package com.example.libroservice;

import com.example.libroservice.model.Libro;
import com.example.libroservice.repository.LibroRepository;
import com.example.libroservice.service.LibroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibroServiceTest {

    @Autowired
    private LibroService libroService;

    @MockBean
    private LibroRepository libroRepository;

    @Test
    void testCrearLibro() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroRepository.save(Mockito.any(Libro.class))).thenReturn(Mono.just(libro));

        Mono<Libro> result = libroService.crear(libro);
        Libro libroCreado = result.block(); // Esperamos que la respuesta se complete de manera sincrónica

        assertNotNull(libroCreado);
        assertEquals("Clean Code", libroCreado.getTitulo());
    }

    @Test
    void testListarLibros() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroRepository.findAll()).thenReturn(Flux.just(libro));

        Flux<Libro> result = libroService.listar();
        assertEquals(1, result.collectList().block().size()); // Verificamos que se devuelva un solo libro
    }

    @Test
    void testObtenerPorId() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroRepository.findById("1")).thenReturn(Mono.just(libro));

        Mono<Libro> result = libroService.obtenerPorId("1");
        Libro libroObtenido = result.block(); // Esperamos la respuesta de forma sincrónica

        assertNotNull(libroObtenido);
        assertEquals("123456", libroObtenido.getIsbn());
    }

    @Test
    void testAsignarAutor() {
        Libro libro = new Libro("1", "Clean Code", "123456", null);
        Mockito.when(libroRepository.findById("1")).thenReturn(Mono.just(libro));
        Mockito.when(libroRepository.save(Mockito.any(Libro.class))).thenReturn(Mono.just(libro));

        Mono<Libro> result = libroService.asignarAutor("1", "autor123");
        Libro libroActualizado = result.block();

        assertNotNull(libroActualizado);
        assertEquals("autor123", libroActualizado.getAutorId());
    }
}
