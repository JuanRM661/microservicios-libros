package com.example.autorservice.repository;

import com.example.autorservice.model.Autor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AutorRepository extends ReactiveMongoRepository<Autor, String> {}