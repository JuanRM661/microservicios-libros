package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SampleServiceTest {

    @Test
    void testServicio() {
        SampleService service = mock(SampleService.class);
        when(service.saludar()).thenReturn("Hola");
        assertEquals("Hola", service.saludar());
    }
}
