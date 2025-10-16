/*
C04_RegistroEnArreglo
Qué hace:
  - Simula un "mini-inventario" usando un arreglo de Strings y un contador.
  - Permite agregar, listar y eliminar por índice.

Objetivo de aprendizaje de la clase:
  - Usar arreglos unidimensionales y control de índices.
  - Emplear ciclos y condicionales para CRUD básico en memoria.

Siguientes pasos para modificar (alumno):
  - Cambiar el arreglo de String por una clase Producto (POJO con nombre, precio, stock).
  - Validar índices y evitar duplicados.
  - Persistir los datos en archivo (preparación para la siguiente clase).
*/

import java.util.Scanner;

public class C04_RegistroEnArreglo {
    public static void main(String[] args) {
        final int MAX = 50;
        String[] items = new String[MAX];
        int size = 0;

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== REGISTRO EN ARREGLO ===");
            System.out.println("1) Agregar");
            System.out.println("2) Listar");
            System.out.println("3) Eliminar por índice");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    if (size >= MAX) {
                        System.out.println("Arreglo lleno.");
                    } else {
                        System.out.print("Nombre del item: ");
                        String nombre = sc.nextLine();
                        items[size++] = nombre;
                        System.out.println("Agregado.");
                    }
                    break;
                case 2:
                    System.out.println("-- Lista --");
                    for (int i = 0; i < size; i++) {
                        System.out.printf("%d) %s%n", i, items[i]);
                    }
                    break;
                case 3:
                    System.out.print("Índice a eliminar: ");
                    int idx = Integer.parseInt(sc.nextLine());
                    if (idx < 0 || idx >= size) {
                        System.out.println("Índice inválido.");
                    } else {
                        for (int i = idx; i < size - 1; i++) {
                            items[i] = items[i + 1];
                        }
                        size--;
                        System.out.println("Eliminado.");
                    }
                    break;
                case 0:
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
