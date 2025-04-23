package com.example.libroservice.repository;

import com.example.libroservice.model.Libro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LibroRepository extends ReactiveMongoRepository<Libro, String> {}