# Add project specific ProGuard rules here.
# Aquí puedes agregar reglas específicas de ofuscación y optimización para tu proyecto.

# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
# Puedes decidir en build.gradle qué archivos de configuración ProGuard aplicar
# usando la opción proguardFiles.

#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html
# Más información en la documentación oficial (aunque la URL ya es vieja).

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
# Si tu app usa WebView y JavaScript, necesitas mantener las clases que se
# exponen a JS. Descomenta esto y coloca el nombre de tu clase.

#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
# Si quieres mantener la información de número de línea para los stack traces
# (útil para debugging), descomenta la siguiente línea.

#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
# Si decides mantener los números de línea, pero no quieres exponer los nombres
# de archivos fuente originales en los stack traces, descomenta esto.

#-renamesourcefileattribute SourceFile
