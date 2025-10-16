/*
C03_MenuConEstructuras
Qué hace:
  - Implementa un menú de texto con while/switch.
  - Ofrece opciones simples (eco de texto, suma de dos números) y salir.

Objetivo de aprendizaje de la clase:
  - Practicar estructuras de control: condicionales (if/switch) y ciclos (while).
  - Diseñar menús de consola con validaciones básicas.

Siguientes pasos para modificar (alumno):
  - Agregar una opción "calculadora" con +, -, *, /.
  - Repetir la lectura si la opción no existe.
  - Estructurar cada opción en métodos separados.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class C03_MenuConEstructuras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1) Eco de texto");
            System.out.println("2) Suma de dos números");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Texto a repetir: ");
                        String texto = sc.nextLine();
                        System.out.println("Eco: " + texto);
                        break;
                    case 2:
                        System.out.print("Número A: ");
                        double a = sc.nextDouble();
                        System.out.print("Número B: ");
                        double b = sc.nextDouble();
                        System.out.println("Suma = " + (a + b));
                        break;
                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                sc.nextLine(); // descartar entrada inválida
            }
        }
        sc.close();
    }
}
