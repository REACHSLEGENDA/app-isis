package com.example.carritoapp
// Paquete principal de la app

import android.os.Bundle
// Importa Bundle, usado en onCreate para recibir datos de estado

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// Importa clases para crear actividades con Compose

import androidx.compose.foundation.layout.*
// Importa componentes de layout: Row, Column, Spacer, etc.

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
// Importa LazyColumn, que permite listas eficientes en Compose

import androidx.compose.foundation.shape.RoundedCornerShape
// Importa forma redondeada para botones, cards, etc.

import androidx.compose.material3.*
// Importa componentes Material 3 (botones, textos, etc.)

import androidx.compose.runtime.*
// Importa herramientas de Compose para manejo de estado (remember, mutableStateOf, etc.)

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// Importa utilidades de Compose UI

import com.example.carritoapp.ui.theme.CarritoAppTheme
// Importa el theme personalizado de la app

import java.util.*
// Importa UUID para generar IDs únicos

// -------------------------
// CLASE MAIN ACTIVITY
// -------------------------

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarritoAppTheme {
                CarritoScreen()
            }
            // Renderiza la UI de la app dentro de CarritoAppTheme
        }
    }
}

// -------------------------
// DATA CLASS
// -------------------------

data class Producto(
    val id: String,
    var nombre: String,
    var precio: Float
)
// Clase de datos que representa un producto en el catálogo y carrito

// -------------------------
// PANTALLA PRINCIPAL
// -------------------------

@Composable
fun CarritoScreen() {
    val catalogo = remember { mutableStateListOf<Producto>() }
    // Lista mutable que contiene los productos del catálogo

    val carrito = remember { mutableStateListOf<Producto>() }
    // Lista mutable que contiene los productos agregados al carrito

    val total = carrito.sumOf { it.precio.toDouble() }
    // Calcula el total sumando los precios del carrito

    var nombre by remember { mutableStateOf("") }
    // Variable de estado para el nombre del producto (campo de texto)

    var precio by remember { mutableStateOf("") }
    // Variable de estado para el precio del producto (campo de texto)

    var editando by remember { mutableStateOf<Producto?>(null) }
    // Variable de estado para saber si se está editando un producto existente

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Lista vertical que contiene todos los elementos de la pantalla

        item {
            Text(
                "Administrar Catálogo",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre del producto") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            // Campo de texto para escribir el nombre del producto

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            // Campo de texto para escribir el precio del producto

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val precioFloat = precio.toFloatOrNull()
                    if (nombre.isNotBlank() && precioFloat != null) {
                        if (editando == null) {
                            catalogo.add(
                                Producto(
                                    id = UUID.randomUUID().toString(),
                                    nombre = nombre,
                                    precio = precioFloat
                                )
                            )
                            // Si no se está editando → crea nuevo producto
                        } else {
                            val index = catalogo.indexOf(editando)
                            if (index != -1) {
                                catalogo[index] = editando!!.copy(
                                    nombre = nombre,
                                    precio = precioFloat
                                )
                                // Si se está editando → actualiza producto existente
                            }
                            editando = null
                        }
                        nombre = ""
                        precio = ""
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(if (editando == null) "Agregar" else "Guardar cambios")
                // Botón cambia su texto según se esté editando o creando
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    catalogo.clear()
                    carrito.clear()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Eliminar TODOS los productos")
                // Botón para borrar todo el catálogo y el carrito
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Catálogo",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        items(catalogo) { producto ->
            ProductoItemAdmin(
                producto = producto,
                onEditClick = {
                    editando = producto
                    nombre = producto.nombre
                    precio = producto.precio.toString()
                },
                onDeleteClick = {
                    catalogo.remove(producto)
                    carrito.remove(producto)
                },
                onAddToCart = {
                    if (!carrito.contains(producto)) {
                        carrito.add(producto)
                    }
                }
            )
            // Muestra cada producto del catálogo con opciones de editar, eliminar o agregar al carrito
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Carrito",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(carrito) { producto ->
            ProductoItemCarrito(
                producto = producto,
                onRemoveClick = {
                    carrito.remove(producto)
                }
            )
            // Muestra cada producto que está en el carrito
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "TOTAL: $${"%.2f".format(total)}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                // Muestra el total del carrito en una caja de color
            }
        }
    }
}

// -------------------------
// COMPONENTE ITEM ADMIN
// -------------------------

@Composable
fun ProductoItemAdmin(
    producto: Producto,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(producto.nombre, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
                Text("$${producto.precio}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Row {
                Button(
                    onClick = onAddToCart,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Agregar")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onEditClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                ) {
                    Text("Editar")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onDeleteClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Eliminar")
                }
            }
        }
    }
}
// Representa visualmente un producto en el catálogo con botones de acción

// -------------------------
// COMPONENTE ITEM CARRITO
// -------------------------

@Composable
fun ProductoItemCarrito(producto: Producto, onRemoveClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(producto.nombre, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSecondaryContainer)
                Text("$${producto.precio}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
            Button(
                onClick = onRemoveClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Eliminar")
            }
        }
    }
}
// Representa visualmente un producto en el carrito con botón de eliminar
