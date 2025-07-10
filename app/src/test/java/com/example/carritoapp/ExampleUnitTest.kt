package com.example.carritoapp
// Paquete donde está el archivo de pruebas

import org.junit.Test
// Importa la anotación @Test para declarar métodos de prueba

import org.junit.Assert.*
// Importa funciones de aserciones (assertEquals, assertTrue, etc.)

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
// Comentario de documentación: explica que es un test unitario local (no se ejecuta en dispositivo físico/emulador)

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        // Prueba de ejemplo que verifica que 2 + 2 es igual a 4
        assertEquals(4, 2 + 2)
        // Si esta igualdad falla, la prueba dará error
    }
}
