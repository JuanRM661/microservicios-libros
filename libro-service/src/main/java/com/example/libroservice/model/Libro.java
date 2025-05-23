package com.example.libroservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "libros")
public class Libro {
    @Id
    private String id;
    private String titulo;
    private String autorId;
}