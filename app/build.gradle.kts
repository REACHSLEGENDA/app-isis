plugins {
    alias(libs.plugins.android.application)
    // Plugin para proyectos Android de tipo aplicación

    alias(libs.plugins.kotlin.android)
    // Plugin para usar Kotlin en proyectos Android

    alias(libs.plugins.kotlin.compose)
    // Plugin para habilitar Jetpack Compose en Kotlin
}

android {
    namespace = "com.example.carritoapp"
    // Define el namespace del proyecto (equivalente al package en Java/Kotlin)

    compileSdk = 35
    // Versión del SDK de Android con la que se compila la app

    defaultConfig {
        applicationId = "com.example.carritoapp"
        // ID único de la app, usado en el Play Store

        minSdk = 24
        // Mínima versión de Android que soporta la app

        targetSdk = 35
        // Versión recomendada de Android sobre la cual se optimiza la app

        versionCode = 1
        // Número interno de versión (incrementa con cada release)

        versionName = "1.0"
        // Nombre visible de la versión (ej. 1.0, 2.5, etc.)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Runner usado para correr instrumented tests (en dispositivo o emulador)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // Indica si se debe ofuscar o minificar el código en versión release

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Archivos ProGuard para optimización y ofuscación en release
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        // Compatibilidad con código Java 11
    }

    kotlinOptions {
        jvmTarget = "11"
        // Configura el bytecode Kotlin para JVM 11
    }

    buildFeatures {
        compose = true
        // Habilita Jetpack Compose en el proyecto
    }
}

dependencies {
    // Dependencias para la app

    implementation(libs.androidx.core.ktx)
    // Librerías core de Android con extensiones Kotlin

    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Soporte para ciclo de vida (lifecycle) con Kotlin

    implementation(libs.androidx.activity.compose)
    // Permite usar Compose dentro de actividades

    implementation(platform(libs.androidx.compose.bom))
    // BOM (Bill of Materials) para mantener versiones compatibles entre dependencias Compose

    implementation(libs.androidx.ui)
    // Componentes básicos de UI de Compose

    implementation(libs.androidx.ui.graphics)
    // Clases de gráficos para Compose (ej. Color, Path)

    implementation(libs.androidx.ui.tooling.preview)
    // Permite previsualizar composables en Android Studio

    implementation(libs.androidx.material3)
    // Implementación de Material Design 3 en Compose

    testImplementation(libs.junit)
    // Dependencia para tests unitarios en la JVM

    androidTestImplementation(libs.androidx.junit)
    // Soporte para escribir instrumented tests en Android

    androidTestImplementation(libs.androidx.espresso.core)
    // Librería Espresso para UI Testing en Android

    androidTestImplementation(platform(libs.androidx.compose.bom))
    // BOM de Compose para asegurar versiones compatibles en instrumented tests

    androidTestImplementation(libs.androidx.ui.test.junit4)
    // Librería de tests de Compose

    debugImplementation(libs.androidx.ui.tooling)
    // Herramientas de preview y debugging en Compose (solo en debug)

    debugImplementation(libs.androidx.ui.test.manifest)
    // Dependencia para ejecutar tests de UI en debug
}
