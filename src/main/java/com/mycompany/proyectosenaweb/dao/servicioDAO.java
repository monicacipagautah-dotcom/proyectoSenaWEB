package com.mycompany.proyectosenaweb.dao; // Define el paquete donde está la clase DAO

import com.mycompany.proyectosenaweb.conexion.Conexion; // Importa la clase Conexion para conectarse a la base de datos
import com.mycompany.proyectosenaweb.modelo.Servicio; // Importa la clase Servicio del paquete modelo
import java.sql.Connection; // Permite manejar la conexión con MySQL
import java.sql.PreparedStatement; // Permite ejecutar consultas SQL parametrizadas
import java.sql.ResultSet; // Permite leer los resultados de las consultas SELECT
import java.sql.SQLException; // Permite manejar errores SQL
import java.sql.Types; // Permite enviar valores NULL a la base de datos
import java.util.ArrayList; // Permite crear listas dinámicas
import java.util.List; // Permite trabajar con listas de servicios

public class servicioDAO { // Clase DAO que centraliza las consultas SQL relacionadas con la tabla servicios

    public boolean registrar(Servicio servicio) { // Método para registrar un nuevo servicio

        String sql = "INSERT INTO servicios (id_cliente, id_proveedor, tipo, fecha, hora, direccion, estado) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)"; // Consulta SQL parametrizada para insertar un servicio

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, servicio.getIdCliente()); // Asigna el id del cliente al primer parámetro

            if (servicio.getIdProveedor() != null) { // Verifica si el servicio tiene proveedor asignado
                ps.setInt(2, servicio.getIdProveedor()); // Asigna el id del proveedor
            } else { // Si no tiene proveedor
                ps.setNull(2, Types.INTEGER); // Envía NULL a la base de datos
            }

            ps.setString(3, servicio.getTipo()); // Asigna el tipo de servicio
            ps.setDate(4, servicio.getFecha()); // Asigna la fecha del servicio
            ps.setTime(5, servicio.getHora()); // Asigna la hora del servicio
            ps.setString(6, servicio.getDireccion()); // Asigna la dirección del servicio
            ps.setString(7, servicio.getEstado()); // Asigna el estado del servicio

            return ps.executeUpdate() > 0; // Ejecuta el INSERT y retorna true si guardó un registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al registrar servicio: " + e.getMessage()); // Muestra el error
            return false; // Retorna false si ocurre un error
        }
    }

    public List<Servicio> listar() { // Método para consultar todos los servicios registrados

        List<Servicio> lista = new ArrayList<>(); // Crea una lista vacía para guardar los servicios

        String sql = "SELECT * FROM servicios"; // Consulta SQL para obtener todos los servicios

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql); // Prepara la consulta
             ResultSet rs = ps.executeQuery()) { // Ejecuta el SELECT y guarda los resultados

            while (rs.next()) { // Recorre cada registro encontrado
                Servicio servicio = mapearServicio(rs); // Convierte el registro actual en un objeto Servicio
                lista.add(servicio); // Agrega el servicio a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar servicios: " + e.getMessage()); // Muestra el error
        }

        return lista; // Retorna la lista de servicios
    }

    public Servicio buscarPorId(int idServicio) { // Método para buscar un servicio por id

        String sql = "SELECT * FROM servicios WHERE id_servicio = ?"; // Consulta SQL con WHERE por id

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

            ps.setInt(1, idServicio); // Asigna el id recibido al parámetro

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta
                if (rs.next()) { // Verifica si encontró un servicio
                    return mapearServicio(rs); // Retorna el servicio encontrado
                }
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al buscar servicio por id: " + e.getMessage()); // Muestra el error
        }

        return null; // Retorna null si no encontró servicio
    }

    public boolean actualizar(Servicio servicio) { // Método para actualizar un servicio existente

        String sql = "UPDATE servicios SET id_cliente = ?, id_proveedor = ?, tipo = ?, fecha = ?, hora = ?, direccion = ?, estado = ? "
                   + "WHERE id_servicio = ?"; // Consulta SQL parametrizada para actualizar

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

            ps.setInt(1, servicio.getIdCliente()); // Asigna el id del cliente

            if (servicio.getIdProveedor() != null) { // Verifica si tiene proveedor
                ps.setInt(2, servicio.getIdProveedor()); // Asigna el id del proveedor
            } else { // Si no tiene proveedor
                ps.setNull(2, Types.INTEGER); // Envía NULL a la base de datos
            }

            ps.setString(3, servicio.getTipo()); // Asigna el tipo de servicio
            ps.setDate(4, servicio.getFecha()); // Asigna la fecha
            ps.setTime(5, servicio.getHora()); // Asigna la hora
            ps.setString(6, servicio.getDireccion()); // Asigna la dirección
            ps.setString(7, servicio.getEstado()); // Asigna el estado
            ps.setInt(8, servicio.getIdServicio()); // Asigna el id del servicio que se va a actualizar

            return ps.executeUpdate() > 0; // Ejecuta el UPDATE y retorna true si actualizó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al actualizar servicio: " + e.getMessage()); // Muestra el error
            return false; // Retorna false si ocurre un error
        }
    }

    public boolean eliminar(int idServicio) { // Método para eliminar un servicio por id

        String sql = "DELETE FROM servicios WHERE id_servicio = ?"; // Consulta SQL para eliminar por id

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

            ps.setInt(1, idServicio); // Asigna el id del servicio a eliminar

            return ps.executeUpdate() > 0; // Ejecuta el DELETE y retorna true si eliminó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al eliminar servicio: " + e.getMessage()); // Muestra el error
            return false; // Retorna false si ocurre un error
        }
    }

    private Servicio mapearServicio(ResultSet rs) throws SQLException { // Método privado que convierte un registro SQL en objeto Servicio

        Servicio servicio = new Servicio(); // Crea un objeto Servicio vacío

        servicio.setIdServicio(rs.getInt("id_servicio")); // Asigna el id del servicio
        servicio.setIdCliente(rs.getInt("id_cliente")); // Asigna el id del cliente

        int idProveedor = rs.getInt("id_proveedor"); // Obtiene el id del proveedor desde la base de datos
        if (rs.wasNull()) { // Verifica si el valor recuperado era NULL
            servicio.setIdProveedor(null); // Asigna null si no hay proveedor
        } else { // Si sí hay proveedor
            servicio.setIdProveedor(idProveedor); // Asigna el id del proveedor
        }

        servicio.setTipo(rs.getString("tipo")); // Asigna el tipo del servicio
        servicio.setFecha(rs.getDate("fecha")); // Asigna la fecha del servicio
        servicio.setHora(rs.getTime("hora")); // Asigna la hora del servicio
        servicio.setDireccion(rs.getString("direccion")); // Asigna la dirección del servicio
        servicio.setEstado(rs.getString("estado")); // Asigna el estado del servicio

        return servicio; // Retorna el objeto Servicio cargado con datos
    }
}