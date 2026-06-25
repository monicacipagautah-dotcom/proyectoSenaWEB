package com.mycompany.proyectosenaweb.conexion; // Paquete donde se encuentra la clase Conexion

import java.sql.Connection; // Permite manejar la conexión con la base de datos
import java.sql.DriverManager; // Permite crear la conexión usando la URL, usuario y contraseña
import java.sql.SQLException; // Permite manejar errores relacionados con SQL

public class Conexion { // Clase encargada de conectar Java con MySQL

    private static final String URL = "jdbc:mysql://localhost:3306/proyecto_servicios?useSSL=false&serverTimezone=UTC"; // URL de conexión a la base de datos

    private static final String USER = "root"; // Usuario de MySQL

    private static final String PASSWORD = "Root"; // Contraseña de MySQL

    static { // Bloque que se ejecuta una sola vez cuando se carga la clase
        try { // Intenta cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el driver JDBC de MySQL
            System.out.println("Driver de MySQL cargado correctamente."); // Mensaje si el driver se cargó bien
        } catch (ClassNotFoundException e) { // Captura error si no encuentra el driver
            System.out.println("Error: no se encontró el driver MySQL."); // Muestra mensaje de error
            e.printStackTrace(); // Muestra el detalle del error
        }
    }

    public static Connection obtenerConexion() throws SQLException { // Método que devuelve una conexión activa
        return DriverManager.getConnection(URL, USER, PASSWORD); // Retorna la conexión con MySQL
    }
}