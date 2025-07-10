// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Archivo de build de nivel superior (root), donde se pueden declarar configuraciones globales
// que afecten a todos los módulos del proyecto (app, libraries, etc.)

plugins {
    alias(libs.plugins.android.application) apply false
    // Declara el plugin de aplicación Android, pero con "apply false" porque
    // no se está aplicando aquí directamente, sino que se usará en módulos específicos (ej. :app)

    alias(libs.plugins.kotlin.android) apply false
    // Declara el plugin de Kotlin Android, igualmente sin aplicarlo aquí.
    // Se aplica después en el build.gradle.kts del módulo donde se necesite.

    alias(libs.plugins.kotlin.compose) apply false
    // Declara el plugin de Kotlin Compose, pero sin aplicarlo aquí globalmente.
    // Se aplicará en los módulos que usen Compose.
}
