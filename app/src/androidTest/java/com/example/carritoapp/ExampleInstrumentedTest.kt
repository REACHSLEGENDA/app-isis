package com.example.carritoapp
// Paquete donde se encuentra este archivo de pruebas

import androidx.test.platform.app.InstrumentationRegistry
// Importa InstrumentationRegistry para acceder al contexto de la app durante tests

import androidx.test.ext.junit.runners.AndroidJUnit4
// Importa el runner de JUnit que permite correr pruebas en dispositivos/emuladores Android

import org.junit.Test
// Importa la anotación @Test para declarar métodos de prueba

import org.junit.runner.RunWith
// Importa RunWith para especificar el runner de JUnit

import org.junit.Assert.*
// Importa funciones de aserciones (assertEquals, assertTrue, etc.)

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
// Comentario de documentación de archivo: explica que este test se ejecuta en dispositivo/emulador

@RunWith(AndroidJUnit4::class)
// Indica que esta clase de test se ejecutará con el runner de AndroidJUnit4

class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // Obtiene el contexto de la app en ejecución durante la prueba

        assertEquals("com.example.carritoapp", appContext.packageName)
        // Verifica que el nombre del paquete de la app sea el esperado
    }
}
