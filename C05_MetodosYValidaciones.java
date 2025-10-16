/*
C05_MetodosYValidaciones
Qué hace:
  - Refactoriza cálculos en métodos reutilizables.
  - Incluye validaciones de entrada y uso de try-catch.

Objetivo de aprendizaje de la clase:
  - Modularizar (métodos con parámetros y retorno).
  - Manejar errores comunes con excepciones.

Siguientes pasos para modificar (alumno):
  - Añadir sobrecarga de métodos (mismo nombre, distinta firma).
  - Crear una clase Util con métodos estáticos reutilizables.
  - Escribir pruebas simples (asserts) para validar resultados.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class C05_MetodosYValidaciones {

    public static double leerPositivo(Scanner sc, String etiqueta) {
        while (true) {
            System.out.print(etiqueta + ": ");
            try {
                double v = sc.nextDouble();
                if (v > 0) return v;
                System.out.println("Debe ser > 0.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static double perimetroRectangulo(double base, double altura) {
        return 2 * (base + altura);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = leerPositivo(sc, "Base");
        double altura = leerPositivo(sc, "Altura");

        double perimetro = perimetroRectangulo(base, altura);
        System.out.println("Perímetro = " + perimetro);
        sc.close();
    }
}
