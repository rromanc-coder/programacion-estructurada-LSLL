/*
C06_ArchivosTextoCSV
Qué hace:
  - Guarda y lee registros en un archivo CSV (texto).
  - Permite agregar productos (nombre, precio, cantidad) y listarlos desde el archivo.

Objetivo de aprendizaje de la clase:
  - Manejar archivos: apertura, escritura, lectura y cierre.
  - Aplicar try-with-resources y manejo de excepciones.

Siguientes pasos para modificar (alumno):
  - Validar formato de líneas al leer.
  - Separar la lógica en una clase RepositorioArchivo con métodos guardar/listar.
  - Exportar e importar desde rutas parametrizadas.
*/

import java.io.*;
import java.util.Scanner;

public class C06_ArchivosTextoCSV {
    private static final String ARCHIVO = "productos.csv";

    public static void agregarProducto(String nombre, double precio, int cantidad) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            pw.printf("%s,%.2f,%d%n", nombre, precio, cantidad);
            System.out.println("Producto guardado.");
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }

    public static void listarProductos() {
        File f = new File(ARCHIVO);
        if (!f.exists()) {
            System.out.println("No hay productos aún.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            System.out.println("-- Productos --");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== ARCHIVOS CSV ===");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(sc.nextLine());
                    agregarProducto(nombre, precio, cantidad);
                    break;
                case 2:
                    listarProductos();
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
