pluginManagement {
    // Configura cómo y desde dónde Gradle busca plugins (como AGP, Kotlin, Compose, etc.)

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        // Repositorio Google, incluye Android y librerías de Google
        // El bloque content permite filtrar qué grupos buscar aquí.

        mavenCentral()
        // Repositorio Maven Central (librerías Java/Kotlin open source)

        gradlePluginPortal()
        // Portal oficial de plugins de Gradle
    }
}

dependencyResolutionManagement {
    // Configura cómo Gradle resuelve dependencias de librerías en todos los módulos del proyecto.

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // Previene que módulos individuales definan sus propios repositorios.
    // Solo se usarán los repositorios definidos aquí → evita inconsistencias.

    repositories {
        google()
        // Repositorio oficial de Google (AndroidX, Play Services, etc.)

        mavenCentral()
        // Repositorio Maven Central
    }
}

rootProject.name = "CarritoApp"
// Nombre del proyecto raíz (aparece en Android Studio y en archivos generados)

include(":app")
// Incluye el módulo "app" en la build.
// Si tuvieras más módulos (ej. :core, :feature), se agregarían así:
// include(":core")
// include(":feature:login")
