package com.example.autorservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "autores")
public class Autor {
    @Id
    private String id;
    private String nombre;
}