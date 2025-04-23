package com.example.libroservice.controller;

import com.example.libroservice.model.Libro;
import com.example.libroservice.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService service;

    @PostMapping
    public Mono<Libro> crear(@RequestBody Libro libro) {
        return service.crear(libro);
    }
    @GetMapping
    public Flux<Libro> listar() {
        return service.listar();
    }
    @GetMapping("/{id}")
    public Mono<Libro> obtener(@PathVariable String id) {
        return service.obtenerPorId(id);
    }
    @PutMapping("/{id}/autor")
    public Mono<Libro> asignarAutor(@PathVariable String id, @RequestBody String autorId) {
        return service.asignarAutor(id, autorId);
    }
}