package com.example.autorservice.service;

import com.example.autorservice.model.Autor;
import com.example.autorservice.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repo;

    public Mono<Autor> crear(Autor autor) {
        return repo.save(autor);
    }
}