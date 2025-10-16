# Compendio de Programas — Metodología y Programación de Sistemas (La Salle)

Este repositorio contiene **8 programas Java** alineados con el plan de clase. Cada archivo está **enumerado por clase** y documentado en comentarios con:
- **Qué hace**
- **Objetivo de aprendizaje**
- **Siguientes pasos para modificar**

## Requisitos
- **JDK 17+** (o 11+)
- (Opcional para C08) **Driver JDBC de SQLite**: `org.xerial:sqlite-jdbc`

## Estructura
```
programacion-estructurada-LSLL/
├── C01_HolaMundoDiagnostico.java
├── C02_AlgoritmoAreaTriangulo.java
├── C03_MenuConEstructuras.java
├── C04_RegistroEnArreglo.java
├── C05_MetodosYValidaciones.java
├── C06_ArchivosTextoCSV.java
├── C07_HilosReloj.java
├── C08_JDBC_SQLite_CRUD.java
└── README.md
```

## Cómo compilar y ejecutar (consola)

### 1) Clonar o descargar ZIP
```bash
unzip la_salle_java_compendio.zip
cd la_salle_java_compendio
```

### 2) Compilar y ejecutar un ejemplo
```bash
javac C03_MenuConEstructuras.java
java C03_MenuConEstructuras
```

### 3) Ejecutar el de SQLite (C08)
Necesitas tener el **JAR de sqlite-jdbc** en tu classpath.

- En **Windows (PowerShell/cmd)**:
```bash
javac C08_JDBC_SQLite_CRUD.java
java -cp ".;sqlite-jdbc-<version>.jar" C08_JDBC_SQLite_CRUD
```

- En **macOS/Linux (bash/zsh)**:
```bash
javac C08_JDBC_SQLite_CRUD.java
java -cp ".:sqlite-jdbc-<version>.jar" C08_JDBC_SQLite_CRUD
```

> Sustituye `<version>` por la versión del JAR que descargues.

## Sugerencia didáctica
- **Clase 1–2:** C01 y C02 (estructura base + del problema al algoritmo).
- **Clase 3:** C03 (condicionales y ciclos con menú).
- **Clase 4:** C04 (arreglos, CRUD en memoria).
- **Clase 5:** C05 (métodos, validaciones, excepciones).
- **Clase 6:** C06 (persistencia con archivos de texto).
- **Clase 7:** C07 (hilos).
- **Clase 8:** C08 (JDBC/SQLite, CRUD).

## Licencia
Uso académico y docente.
