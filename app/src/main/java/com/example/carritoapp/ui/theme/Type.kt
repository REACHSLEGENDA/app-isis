package com.example.carritoapp.ui.theme
// Define el paquete donde está este archivo (estructura de carpetas del proyecto)

import androidx.compose.material3.Typography
// Importa la clase Typography de Material3 para definir estilos de texto

import androidx.compose.ui.text.TextStyle
// Clase para definir atributos de texto: tamaño, fuente, peso, etc.

import androidx.compose.ui.text.font.FontFamily
// Permite especificar familias tipográficas (ej. Default, Serif, SansSerif, etc.)

import androidx.compose.ui.text.font.FontWeight
// Permite definir el grosor (peso) de la fuente (ej. Bold, Normal, etc.)

import androidx.compose.ui.unit.sp
// Importa la unidad sp (scale-independent pixels) para definir tamaños de texto

// Conjunto de estilos tipográficos Material Design para comenzar
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        // Familia tipográfica por defecto del sistema

        fontWeight = FontWeight.Normal,
        // Peso de la fuente → Normal (no bold)

        fontSize = 16.sp,
        // Tamaño del texto (16sp → escala independiente)

        lineHeight = 24.sp,
        // Altura de línea (espaciado vertical entre líneas de texto)

        letterSpacing = 0.5.sp
        // Espaciado entre letras
    )
    /* Otros estilos de texto por si quieres sobreescribirlos:

    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    // Estilo para títulos grandes

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    // Estilo para etiquetas pequeñas
    */
)
