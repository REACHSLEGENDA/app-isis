package com.example.carritoapp.ui.theme
// Declara el paquete donde se encuentra este archivo (estructura de carpetas del proyecto)

import android.app.Activity
import android.os.Build
// Imports de Android para detectar versión del sistema operativo

import androidx.compose.foundation.isSystemInDarkTheme
// Función de Jetpack Compose que indica si el sistema está en modo oscuro

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
// Imports de Material3 para definir esquemas de colores (light/dark/dynamic)

import androidx.compose.runtime.Composable
// Importa la anotación @Composable para crear composables

import androidx.compose.ui.platform.LocalContext
// Permite acceder al contexto actual en composables

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)
// Esquema de colores oscuro (modo oscuro).
// primary, secondary, tertiary son colores principales definidos en tu archivo Color.kt

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Otros colores por si quieres sobrescribir:
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
// Esquema de colores claro (modo claro).
// Puedes agregar más colores para personalizar la paleta (comentados aquí arriba)

@Composable
fun CarritoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Indica si la app debe usar tema oscuro o claro.
    // Por defecto, toma el valor del sistema (oscuro o claro).

    dynamicColor: Boolean = true,
    // Indica si se deben usar colores dinámicos (sólo en Android 12 o superior).

    content: @Composable () -> Unit
    // Lambda que contiene el contenido UI que se pintará con este tema.
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // Si dynamicColor es true y el dispositivo tiene Android 12 (API 31) o superior:
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
            // Obtiene paletas dinámicas basadas en el wallpaper del usuario.
        }

        darkTheme -> DarkColorScheme
        // Si está en dark theme y NO se usan dynamic colors → usa esquema oscuro definido arriba.

        else -> LightColorScheme
        // Si no, usa esquema claro definido arriba.
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
    // Aplica el tema seleccionado (colores y tipografías) a todo el contenido de la app.
}
