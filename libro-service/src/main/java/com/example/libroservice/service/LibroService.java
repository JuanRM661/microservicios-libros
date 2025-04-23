package com.example.libroservice.service;

import com.example.libroservice.model.Libro;
import com.example.libroservice.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repo;

    public Mono<Libro> crear(Libro libro) {
        return repo.save(libro);
    }
    public Flux<Libro> listar() {
        return repo.findAll();
    }
    public Mono<Libro> obtenerPorId(String id) {
        return repo.findById(id);
    }
    public Mono<Libro> asignarAutor(String id, String autorId) {
        return repo.findById(id).flatMap(libro -> {
            libro.setAutorId(autorId);
            return repo.save(libro);
        });
    }
}