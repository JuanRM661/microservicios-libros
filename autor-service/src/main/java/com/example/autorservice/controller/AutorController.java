package com.example.autorservice.controller;

import com.example.autorservice.model.Autor;
import com.example.autorservice.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService service;

    @PostMapping
    public Mono<Autor> crear(@RequestBody Autor autor) {
        return service.crear(autor);
    }
}