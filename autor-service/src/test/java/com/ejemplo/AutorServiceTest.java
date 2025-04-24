package com.example.autorservice;

import com.example.autorservice.model.Autor;
import com.example.autorservice.repository.AutorRepository;
import com.example.autorservice.service.AutorService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AutorServiceTest {

    @Test
    void testCrearAutor() {
        // Arrange
        AutorRepository mockRepo = mock(AutorRepository.class);
        Autor autor = new Autor();
        autor.setId("1");
        autor.setNombre("Isabel Allende");

        when(mockRepo.save(autor)).thenReturn(Mono.just(autor));

        AutorService service = new AutorService(mockRepo);

        // Act
        Mono<Autor> resultado = service.crear(autor);

        // Assert
        Autor autorGuardado = resultado.block();
        assertEquals("Isabel Allende", autorGuardado.getNombre());
        assertEquals("1", autorGuardado.getId());

        verify(mockRepo, times(1)).save(autor);
    }
}
