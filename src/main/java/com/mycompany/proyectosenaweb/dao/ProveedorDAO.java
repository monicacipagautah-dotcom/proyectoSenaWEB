package com.mycompany.proyectosenaweb.dao; // Define el paquete donde está la clase DAO

import com.mycompany.proyectosenaweb.conexion.Conexion; // Importa la clase Conexion para obtener conexión con MySQL
import com.mycompany.proyectosenaweb.modelo.Proveedor; // Importa la clase Proveedor del paquete modelo
import java.sql.Connection; // Permite manejar la conexión con la base de datos
import java.sql.PreparedStatement; // Permite ejecutar consultas SQL parametrizadas
import java.sql.ResultSet; // Permite leer resultados de consultas SELECT
import java.sql.SQLException; // Permite manejar errores SQL
import java.util.ArrayList; // Permite crear listas dinámicas
import java.util.List; // Permite trabajar con listas de proveedores

public class ProveedorDAO { // Clase DAO que centraliza las consultas SQL relacionadas con la tabla proveedores

    public boolean registrar(Proveedor proveedor) { // Método para registrar un nuevo proveedor

        String sql = "INSERT INTO proveedores (id_usuario, foto_personal, estado_validacion) "
                   + "VALUES (?, ?, ?)"; // Consulta SQL parametrizada para insertar proveedor

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, proveedor.getIdUsuario()); // Asigna el id_usuario al primer parámetro
            ps.setString(2, proveedor.getFotoPersonal()); // Asigna la foto personal al segundo parámetro
            ps.setString(3, proveedor.getEstadoValidacion()); // Asigna el estado de validación al tercer parámetro

            return ps.executeUpdate() > 0; // Ejecuta el INSERT y retorna true si guardó un registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al registrar proveedor: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    public List<Proveedor> listar() { // Método para consultar todos los proveedores registrados

        List<Proveedor> lista = new ArrayList<>(); // Crea una lista vacía para guardar proveedores

        String sql = "SELECT * FROM proveedores"; // Consulta SQL para obtener todos los proveedores

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql); // Prepara la consulta
             ResultSet rs = ps.executeQuery()) { // Ejecuta el SELECT y obtiene resultados

            while (rs.next()) { // Recorre cada registro encontrado
                Proveedor proveedor = mapearProveedor(rs); // Convierte el registro actual en objeto Proveedor
                lista.add(proveedor); // Agrega el proveedor a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar proveedores: " + e.getMessage()); // Muestra el mensaje del error
        }

        return lista; // Retorna la lista de proveedores
    }

    public Proveedor buscarPorId(int idProveedor) { // Método para buscar un proveedor por id

        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?"; // Consulta SQL con WHERE por id_proveedor

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

            ps.setInt(1, idProveedor); // Asigna el idProveedor al parámetro de la consulta

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene resultados
                if (rs.next()) { // Verifica si encontró un proveedor
                    return mapearProveedor(rs); // Retorna el proveedor encontrado
                }
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al buscar proveedor por id: " + e.getMessage()); // Muestra el mensaje del error
        }

        return null; // Retorna null si no encontró proveedor
    }

    public boolean actualizar(Proveedor proveedor) { // Método para actualizar un proveedor existente

        String sql = "UPDATE proveedores SET id_usuario = ?, foto_personal = ?, estado_validacion = ? "
                   + "WHERE id_proveedor = ?"; // Consulta SQL parametrizada para actualizar

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, proveedor.getIdUsuario()); // Asigna el id_usuario
            ps.setString(2, proveedor.getFotoPersonal()); // Asigna la foto personal
            ps.setString(3, proveedor.getEstadoValidacion()); // Asigna el estado de validación
            ps.setInt(4, proveedor.getIdProveedor()); // Asigna el id_proveedor del registro que se actualizará

            return ps.executeUpdate() > 0; // Ejecuta el UPDATE y retorna true si actualizó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al actualizar proveedor: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    public boolean eliminar(int idProveedor) { // Método para eliminar un proveedor por id

        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?"; // Consulta SQL para eliminar por id_proveedor

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, idProveedor); // Asigna el id del proveedor que se eliminará

            return ps.executeUpdate() > 0; // Ejecuta el DELETE y retorna true si eliminó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al eliminar proveedor: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    private Proveedor mapearProveedor(ResultSet rs) throws SQLException { // Método privado para convertir un registro SQL en objeto Proveedor

        Proveedor proveedor = new Proveedor(); // Crea un objeto Proveedor vacío

        proveedor.setIdProveedor(rs.getInt("id_proveedor")); // Asigna el id_proveedor recuperado de la base de datos
        proveedor.setIdUsuario(rs.getInt("id_usuario")); // Asigna el id_usuario recuperado
        proveedor.setFotoPersonal(rs.getString("foto_personal")); // Asigna la foto personal recuperada
        proveedor.setEstadoValidacion(rs.getString("estado_validacion")); // Asigna el estado de validación recuperado

        return proveedor; // Retorna el objeto Proveedor con los datos cargados
    }
    
    public List<String[]> listarConNombre() { // Método que lista proveedores mostrando el nombre del usuario

        List<String[]> lista = new ArrayList<>(); // Lista donde se guardará id_proveedor y nombre

        String sql = "SELECT p.id_proveedor, u.nombre " // Selecciona el id del proveedor y el nombre del usuario
                + "FROM proveedores p " // Tabla proveedores con alias p
                + "INNER JOIN usuarios u ON p.id_usuario = u.id_usuario " // Une proveedores con usuarios
                + "ORDER BY u.nombre"; // Ordena por nombre

        try (Connection con = Conexion.obtenerConexion(); // Abre conexión
                 PreparedStatement ps = con.prepareStatement(sql); // Prepara la consulta
                 ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta

            while (rs.next()) { // Recorre cada resultado
                String[] datos = new String[2]; // Crea arreglo para guardar dos datos
                datos[0] = String.valueOf(rs.getInt("id_proveedor")); // Guarda el id_proveedor
                datos[1] = rs.getString("nombre"); // Guarda el nombre del proveedor
                lista.add(datos); // Agrega los datos a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar proveedores con nombre: " + e.getMessage()); // Muestra error
        }

        return lista; // Retorna la lista
    }
}