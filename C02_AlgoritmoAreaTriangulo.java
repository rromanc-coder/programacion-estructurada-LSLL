/*
C02_AlgoritmoAreaTriangulo
Qué hace:
  - Muestra cómo pasar de un problema a un algoritmo y código.
  - Calcula el área de un triángulo (base*altura/2) con validación simple.

Objetivo de aprendizaje de la clase:
  - Aplicar metodología: análisis → diseño (pseudocódigo) → codificación → prueba.
  - Usar variables, operadores y E/S básica.

Siguientes pasos para modificar (alumno):
  - Agregar opciones para calcular áreas de otras figuras (cuadrado, círculo).
  - Manejar excepciones cuando la entrada no es numérica.
  - Encapsular el cálculo en un método separado.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class C02_AlgoritmoAreaTriangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = 0, altura = 0;

        try {
            System.out.print("Base del triángulo: ");
            base = sc.nextDouble();

            System.out.print("Altura del triángulo: ");
            altura = sc.nextDouble();

            if (base <= 0 || altura <= 0) {
                System.out.println("La base y la altura deben ser positivas.");
            } else {
                double area = (base * altura) / 2.0;
                System.out.println("Área = " + area);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debes introducir números.");
        } finally {
            sc.close();
        }
    }
}
