package com.mycompany.proyectosenaweb.dao; // Define el paquete donde está la clase DAO

import com.mycompany.proyectosenaweb.conexion.Conexion; // Importa la clase Conexion para conectarse a MySQL
import com.mycompany.proyectosenaweb.modelo.Usuario; // Importa la clase Usuario del paquete modelo
import java.sql.Connection; // Permite manejar la conexión con la base de datos
import java.sql.PreparedStatement; // Permite ejecutar consultas SQL parametrizadas
import java.sql.ResultSet; // Permite leer los resultados de una consulta SELECT
import java.sql.SQLException; // Permite manejar errores SQL
import java.util.ArrayList; // Permite crear listas dinámicas
import java.util.List; // Permite trabajar con listas de usuarios
import java.sql.Statement; // Permite obtener el id generado automáticamente

public class UsuarioDAO { // Clase DAO que centraliza las consultas SQL de la tabla usuarios

public int registrar(Usuario usuario) { // Método para crear usuario y retornar el id generado

    String sql = "INSERT INTO usuarios (nombre, foto_perfil, correo, telefono, password_hash, foto_cedula, fecha_nacimiento, estado, rol) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Consulta SQL parametrizada

    try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Prepara la consulta y permite recuperar el id

        ps.setString(1, usuario.getNombre()); // Asigna el nombre
        ps.setString(2, usuario.getFotoPerfil()); // Asigna la foto de perfil
        ps.setString(3, usuario.getCorreo()); // Asigna el correo
        ps.setString(4, usuario.getTelefono()); // Asigna el teléfono
        ps.setString(5, usuario.getPasswordHash()); // Asigna la contraseña
        ps.setString(6, usuario.getFotoCedula()); // Asigna la foto de cédula
        ps.setDate(7, usuario.getFechaNacimiento()); // Asigna la fecha de nacimiento
        ps.setString(8, usuario.getEstado()); // Asigna el estado
        ps.setString(9, usuario.getRol()); // Asigna el rol

        int filas = ps.executeUpdate(); // Ejecuta el INSERT

        if (filas > 0) { // Verifica si se guardó el usuario
            try (ResultSet rs = ps.getGeneratedKeys()) { // Obtiene las claves generadas
                if (rs.next()) { // Verifica si existe una clave generada
                    return rs.getInt(1); // Retorna el id_usuario generado
                }
            }
        }

    } catch (SQLException e) { // Captura errores SQL
        System.out.println("Error al registrar usuario: " + e.getMessage()); // Muestra el error
    }

    return 0; // Retorna 0 si no pudo registrar
}

    public List<Usuario> listar() { // Método para consultar todos los usuarios registrados

        List<Usuario> lista = new ArrayList<>(); // Crea una lista vacía para guardar usuarios

        String sql = "SELECT * FROM usuarios"; // Consulta SQL para obtener todos los usuarios

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql); // Prepara la consulta SQL
             ResultSet rs = ps.executeQuery()) { // Ejecuta el SELECT y guarda el resultado

            while (rs.next()) { // Recorre cada registro encontrado
                Usuario usuario = mapearUsuario(rs); // Convierte el registro actual en objeto Usuario
                lista.add(usuario); // Agrega el usuario a la lista
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al listar usuarios: " + e.getMessage()); // Muestra el mensaje del error
        }

        return lista; // Retorna la lista de usuarios
    }

    public Usuario buscarPorId(int idUsuario) { // Método para buscar un usuario por su id

        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?"; // Consulta con WHERE para buscar por id

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, idUsuario); // Asigna el id recibido al parámetro de la consulta

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y recibe el resultado
                if (rs.next()) { // Verifica si encontró un usuario
                    return mapearUsuario(rs); // Retorna el usuario encontrado
                }
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al buscar usuario por id: " + e.getMessage()); // Muestra el mensaje del error
        }

        return null; // Retorna null si no encontró usuario
    }

    public Usuario buscarPorCorreo(String correo) { // Método para buscar un usuario por correo

        String sql = "SELECT * FROM usuarios WHERE correo = ?"; // Consulta con WHERE para buscar por correo

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setString(1, correo); // Asigna el correo recibido al parámetro de la consulta

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y recibe el resultado
                if (rs.next()) { // Verifica si encontró un usuario
                    return mapearUsuario(rs); // Retorna el usuario encontrado
                }
            }

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al buscar usuario por correo: " + e.getMessage()); // Muestra el mensaje del error
        }

        return null; // Retorna null si no encontró usuario
    }

    public boolean actualizar(Usuario usuario) { // Método para actualizar los datos de un usuario

        String sql = "UPDATE usuarios SET nombre = ?, foto_perfil = ?, correo = ?, telefono = ?, password_hash = ?, "
                   + "foto_cedula = ?, fecha_nacimiento = ?, estado = ?, rol = ? WHERE id_usuario = ?"; // Consulta SQL parametrizada

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setString(1, usuario.getNombre()); // Asigna el nombre
            ps.setString(2, usuario.getFotoPerfil()); // Asigna la foto de perfil
            ps.setString(3, usuario.getCorreo()); // Asigna el correo
            ps.setString(4, usuario.getTelefono()); // Asigna el teléfono
            ps.setString(5, usuario.getPasswordHash()); // Asigna la contraseña o hash
            ps.setString(6, usuario.getFotoCedula()); // Asigna la foto de cédula
            ps.setDate(7, usuario.getFechaNacimiento()); // Asigna la fecha de nacimiento
            ps.setString(8, usuario.getEstado()); // Asigna el estado
            ps.setString(9, usuario.getRol()); // Asigna el rol
            ps.setInt(10, usuario.getIdUsuario()); // Asigna el id del usuario que se va a actualizar

            return ps.executeUpdate() > 0; // Ejecuta el UPDATE y retorna true si actualizó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al actualizar usuario: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    public boolean eliminar(int idUsuario) { // Método para eliminar un usuario por id

        String sql = "DELETE FROM usuarios WHERE id_usuario = ?"; // Consulta SQL para eliminar por id

        try (Connection con = Conexion.obtenerConexion(); // Abre la conexión con la base de datos
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta SQL

            ps.setInt(1, idUsuario); // Asigna el id del usuario que se va a eliminar

            return ps.executeUpdate() > 0; // Ejecuta el DELETE y retorna true si eliminó algún registro

        } catch (SQLException e) { // Captura errores SQL
            System.out.println("Error al eliminar usuario: " + e.getMessage()); // Muestra el mensaje del error
            return false; // Retorna false si ocurre un error
        }
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException { // Método privado para convertir un registro SQL en objeto Usuario

        Usuario usuario = new Usuario(); // Crea un objeto Usuario vacío

        usuario.setIdUsuario(rs.getInt("id_usuario")); // Asigna el id recuperado desde la base de datos
        usuario.setNombre(rs.getString("nombre")); // Asigna el nombre recuperado desde la base de datos
        usuario.setFotoPerfil(rs.getString("foto_perfil")); // Asigna la foto de perfil recuperada
        usuario.setCorreo(rs.getString("correo")); // Asigna el correo recuperado
        usuario.setTelefono(rs.getString("telefono")); // Asigna el teléfono recuperado
        usuario.setPasswordHash(rs.getString("password_hash")); // Asigna la contraseña o hash recuperado
        usuario.setFotoCedula(rs.getString("foto_cedula")); // Asigna la foto de cédula recuperada
        usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento")); // Asigna la fecha de nacimiento recuperada
        usuario.setEstado(rs.getString("estado")); // Asigna el estado recuperado
        usuario.setRol(rs.getString("rol")); // Asigna el rol recuperado

        return usuario; // Retorna el objeto Usuario con los datos cargados
    }
    
    public Usuario validarLogin(String correo, String passwordHash) { // Método para validar inicio de sesión

    String sql = "SELECT * FROM usuarios WHERE correo = ? AND password_hash = ?"; // Consulta SQL con correo y contraseña

    try (Connection con = Conexion.obtenerConexion(); // Abre la conexión
         PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la consulta

        ps.setString(1, correo); // Asigna el correo al primer parámetro
        ps.setString(2, passwordHash); // Asigna la contraseña al segundo parámetro

        try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta
            if (rs.next()) { // Verifica si encontró usuario
                return mapearUsuario(rs); // Retorna el usuario encontrado
            }
        }

    } catch (SQLException e) { // Captura errores SQL
        System.out.println("Error al validar login: " + e.getMessage()); // Muestra el error
    }

    return null; // Retorna null si no encontró usuario
}
}