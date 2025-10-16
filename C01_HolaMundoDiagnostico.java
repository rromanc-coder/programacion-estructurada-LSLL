/*
C01_HolaMundoDiagnostico
Qué hace:
  - Imprime un mensaje de bienvenida y realiza un pequeño "diagnóstico" pidiendo datos simples por consola:
    nombre, edad y si ha programado antes (true/false).

Objetivo de aprendizaje de la clase:
  - Reconocer la estructura mínima de un programa en Java (clase, método main).
  - Ejecutar E/S básica por consola con Scanner.
  - Practicar tipos de datos primitivos (String, int, boolean).

Siguientes pasos para modificar (alumno):
  - Agrega nuevas preguntas (p. ej., lenguaje favorito, horas de estudio).
  - Valida entradas (si edad < 0, volver a pedir).
  - Resume los resultados en un solo mensaje formateado.
*/

import java.util.Scanner;

public class C01_HolaMundoDiagnostico {
    public static void main(String[] args) {
        System.out.println("¡Bienvenidos a Metodología y Programación de Sistemas!");
        Scanner sc = new Scanner(System.in);

        System.out.print("Tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Tu edad: ");
        int edad = sc.nextInt();

        System.out.print("¿Has programado antes? (true/false): ");
        boolean experiencia = sc.nextBoolean();

        System.out.println("\nResumen:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Experiencia previa: " + (experiencia ? "Sí" : "No"));

        sc.close();
    }
}
