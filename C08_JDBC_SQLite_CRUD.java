/*
C08_JDBC_SQLite_CRUD
Qué hace:
  - Conecta a una base de datos SQLite con JDBC y ejecuta operaciones básicas:
    crear tabla, insertar y listar registros.

Objetivo de aprendizaje de la clase:
  - Configurar conexión JDBC (URL SQLite).
  - Ejecutar sentencias SQL (DDL/DML) desde Java.

Siguientes pasos para modificar (alumno):
  - Añadir UPDATE y DELETE.
  - Encapsular en una clase DAO (ProductoDAO) con métodos: crearTabla, insertar, listar, actualizar, eliminar.
  - Integrar el CRUD con el menú de clases anteriores.

Notas:
  - Requiere el driver JDBC de SQLite (dependencia org.xerial:sqlite-jdbc) en el classpath.
  - URL típica: jdbc:sqlite:mi_bd.db
*/

import java.sql.*;

public class C08_JDBC_SQLite_CRUD {
    private static final String URL = "jdbc:sqlite:mi_bd.db";

    public static void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nombre TEXT NOT NULL," +
                     "precio REAL NOT NULL," +
                     "cantidad INTEGER NOT NULL)";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement st = conn.createStatement()) {
            st.execute(sql);
            System.out.println("Tabla lista.");
        } catch (SQLException e) {
            System.out.println("Error crear tabla: " + e.getMessage());
        }
    }

    public static void insertar(String nombre, double precio, int cantidad) {
        String sql = "INSERT INTO productos(nombre, precio, cantidad) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
            System.out.println("Insertado: " + nombre);
        } catch (SQLException e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    public static void listar() {
        String sql = "SELECT id, nombre, precio, cantidad FROM productos";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("-- Productos --");
            while (rs.next()) {
                System.out.printf("%d) %s | $%.2f | x%d%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearTabla();
        insertar("Cuaderno", 49.90, 10);
        insertar("Pluma", 12.00, 25);
        listar();
    }
}
