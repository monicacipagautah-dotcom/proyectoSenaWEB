package com.mycompany.proyectosenaweb.dao; // Define el paquete donde está la clase DAO

import com.mycompany.proyectosenaweb.conexion.Conexion; // Importa la clase Conexion para obtener conexión con MySQL
import com.mycompany.proyectosenaweb.modelo.Cliente; // Importa la clase Cliente del paquete modelo
import java.sql.Connection; // Permite manejar la conexión con la base de datos
import java.sql.PreparedStatement; // Permite ejecutar consultas SQL parametrizadas
import java.sql.ResultSet; // Permite leer resultados de consultas SELECT
import java.sql.SQLException; // Permite manejar errores SQL
import java.util.ArrayList; // Permite crear listas dinámicas
import java.util.List; // Permite trabajar con listas de clientes
import java.sql.Statement; // Permite obtener el ID generado automáticamente

public class ClienteDAO { // Clase DAO que centraliza las consultas SQL relacionadas con la tabla clientes

public int registrar(Cliente cliente) { // Método para registrar cliente y retornar el id generado

    String sql = "INSERT INTO clientes (id_usuario, biografia, intenciones, numero_contactos, direccion) "
               + "VALUES (?, ?, ?, ?, ?)"; // Consulta SQL para insertar cliente

    try (Connection con = Conexion.obtenerConexion(); // Abre conexión
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Prepara consulta y permite obtener ID

        ps.setInt(1, cliente.getIdUsuario()); // Asigna id_usuario
        ps.setString(2, cliente.getBiografia()); // Asigna biografía
        ps.setString(3, cliente.getIntenciones()); // Asigna intenciones
        ps.setInt(4, cliente.getNumeroContactos()); // Asigna número de contactos
        ps.setString(5, cliente.getDireccion()); // Asigna dirección

        int filas = ps.executeUpdate(); // Ejecuta el INSERT

        if (filas > 0) { // Verifica si se insertó
            try (ResultSet rs = ps.getGeneratedKeys()) { // Obtiene el ID generado
                if (rs.next()) { // Si existe ID generado
                    return rs.getInt(1); // Retorna el id_cliente
                }
            }
        }

    } catch (SQLException e) { // Captura errores SQL
        System.out.println("Error al registrar cliente: " + e.getMessage()); // Muestra error
    }

    return 0; // Retorna 0 si no se pudo registrar
}

    public List<Cliente> listar() { // Método para consultar todos los clientes registrados

        List<Cliente> lista = new ArrayList<>(); // Crea una lista vacía para guardar clientes

        String sql = "SELECT * FROM clientes"; // Consulta SQL para obtener todos los clientes

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql); // Prepara la consulta
             ResultSet rs = ps.executeQuery()) { // Ejecuta el SELECT y obtiene resultados

            while (rs.next()) { // Recorre cada registro encontrado
                Cliente cliente = mapearCliente(rs); // Convierte el registro actual en objeto Cliente
                lista.add(cliente); // Agrega el cliente a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar clientes: " + e.getMessage()); // Muestra el mensaje del error
        }

        return lista; // Retorna la lista de clientes
    }

    public Cliente buscarPorId(int idCliente) { // Método para buscar un cliente por id

        String sql = "SELECT * FROM clientes WHERE id_cliente = ?"; // Consulta SQL con WHERE por id_cliente

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

            ps.setInt(1, idCliente); // Asigna el idCliente al parámetro de la consulta

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene resultados
                if (rs.next()) { // Verifica si encontró un cliente
                    return mapearCliente(rs); // Retorna el cliente encontrado
                }
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al buscar cliente por id: " + e.getMessage()); // Muestra el mensaje del error
        }

        return null; // Retorna null si no encontró cliente
    }

    public boolean actualizar(Cliente cliente) { // Método para actualizar un cliente existente

        String sql = "UPDATE clientes SET id_usuario = ?, biografia = ?, intenciones = ?, numero_contactos = ?, direccion = ? "
                   + "WHERE id_cliente = ?"; // Consulta SQL parametrizada para actualizar

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, cliente.getIdUsuario()); // Asigna el id_usuario
            ps.setString(2, cliente.getBiografia()); // Asigna la biografía
            ps.setString(3, cliente.getIntenciones()); // Asigna las intenciones
            ps.setInt(4, cliente.getNumeroContactos()); // Asigna el número de contactos
            ps.setString(5, cliente.getDireccion()); // Asigna la dirección
            ps.setInt(6, cliente.getIdCliente()); // Asigna el id_cliente del registro que se actualizará

            return ps.executeUpdate() > 0; // Ejecuta el UPDATE y retorna true si actualizó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al actualizar cliente: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    public boolean eliminar(int idCliente) { // Método para eliminar un cliente por id

        String sql = "DELETE FROM clientes WHERE id_cliente = ?"; // Consulta SQL para eliminar por id_cliente

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, idCliente); // Asigna el id del cliente que se eliminará

            return ps.executeUpdate() > 0; // Ejecuta el DELETE y retorna true si eliminó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al eliminar cliente: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException { // Método privado para convertir un registro SQL en objeto Cliente

        Cliente cliente = new Cliente(); // Crea un objeto Cliente vacío

        cliente.setIdCliente(rs.getInt("id_cliente")); // Asigna el id_cliente recuperado de la base de datos
        cliente.setIdUsuario(rs.getInt("id_usuario")); // Asigna el id_usuario recuperado
        cliente.setBiografia(rs.getString("biografia")); // Asigna la biografía recuperada
        cliente.setIntenciones(rs.getString("intenciones")); // Asigna las intenciones recuperadas
        cliente.setNumeroContactos(rs.getInt("numero_contactos")); // Asigna el número de contactos recuperado
        cliente.setDireccion(rs.getString("direccion")); // Asigna la dirección recuperada

        return cliente; // Retorna el objeto Cliente con los datos cargados
    }
    public List<String[]> listarConNombre() { // Método para listar clientes junto con el nombre del usuario

        List<String[]> lista = new ArrayList<>(); // Lista donde se guardará id_cliente y nombre

        String sql = "SELECT c.id_cliente, u.nombre "
                + "FROM clientes c "
                + "INNER JOIN usuarios u ON c.id_usuario = u.id_usuario "
                + "ORDER BY u.nombre"; // Consulta que une clientes con usuarios

        try (Connection con = Conexion.obtenerConexion(); // Abre conexión con la base de datos
                 PreparedStatement ps = con.prepareStatement(sql); // Prepara consulta SQL
                 ResultSet rs = ps.executeQuery()) { // Ejecuta consulta

            while (rs.next()) { // Recorre cada registro encontrado
                String[] datos = new String[2]; // Arreglo para guardar dos datos
                datos[0] = String.valueOf(rs.getInt("id_cliente")); // Guarda id_cliente
                datos[1] = rs.getString("nombre"); // Guarda nombre del cliente
                lista.add(datos); // Agrega los datos a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar clientes con nombre: " + e.getMessage()); // Muestra error
        }

        return lista; // Retorna lista de clientes con nombre
    }
}