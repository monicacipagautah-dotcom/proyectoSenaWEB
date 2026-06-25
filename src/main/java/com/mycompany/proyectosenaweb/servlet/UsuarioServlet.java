package com.mycompany.proyectosenaweb.servlet; // Paquete donde se encuentra el Servlet

import com.mycompany.proyectosenaweb.dao.UsuarioDAO; // Importa el DAO de Usuario 
import com.mycompany.proyectosenaweb.modelo.Usuario;// Importa el modelo Usuario
import jakarta.servlet.ServletException; // Maneja errores propios de Servlet
import jakarta.servlet.annotation.WebServlet; // Permite definir la URL del Servlet con anotación
import jakarta.servlet.http.HttpServlet; // Clase base para crear Servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Permite recibir datos enviados desde formularios o URL
import jakarta.servlet.http.HttpServletResponse; // Permite enviar respuestas o redirecciones
import java.io.IOException; // Maneja errores de entrada y salida
import java.sql.Date; // Permite manejar fechas tipo SQL

@WebServlet("/UsuarioServlet") // URL para acceder al Servlet desde el navegador
public class UsuarioServlet extends HttpServlet { // Clase Servlet para manejar acciones de usuarios

    private final UsuarioDAO dao = new UsuarioDAO(); // Crea un objeto DAO para usar métodos de base de datos

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende peticiones GET

        String accion = request.getParameter("accion"); // Obtiene la acción enviada por la URL

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("index.jsp"); // Redirige a la página principal
            return; // Termina el método
        }

        switch (accion) { // Evalúa qué acción se pidió

            case "listar": // Acción para listar usuarios
                request.setAttribute("listaUsuarios", dao.listar()); // Envía la lista al JSP
                request.getRequestDispatcher("listar.jsp").forward(request, response); // Abre la vista
                break; // Termina este caso

            case "editar": // Acción para cargar datos de un usuario y editarlos
                int idEditar = Integer.parseInt(request.getParameter("id")); // Obtiene el id desde la URL
                Usuario usuarioEditar = dao.buscarPorId(idEditar); // Busca el usuario en la base de datos
                request.setAttribute("usuario", usuarioEditar); // Envía el usuario encontrado al JSP
                request.getRequestDispatcher("editar.jsp").forward(request, response); // Abre la vista de edición
                break; // Termina este caso

            case "eliminar": // Acción para eliminar usuario
                int idEliminar = Integer.parseInt(request.getParameter("id")); // Obtiene el id desde la URL
                dao.eliminar(idEliminar); // Elimina el usuario en la base de datos
                response.sendRedirect("UsuarioServlet?accion=listar"); // Vuelve a la lista
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("index.jsp"); // Redirige al inicio
                break; // Termina este caso
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende formularios POST

        request.setCharacterEncoding("UTF-8"); // Permite recibir tildes y caracteres especiales correctamente

        String accion = request.getParameter("accion"); // Obtiene la acción enviada desde el formulario

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("index.jsp"); // Redirige al inicio
            return; // Termina el método
        }

        switch (accion) { // Evalúa la acción recibida

            case "guardar": // Acción para guardar un usuario nuevo
                Usuario nuevoUsuario = new Usuario(); // Crea un objeto Usuario vacío

                nuevoUsuario.setNombre(request.getParameter("nombre")); // Asigna el nombre
                nuevoUsuario.setFotoPerfil(request.getParameter("fotoPerfil")); // Asigna la foto de perfil
                nuevoUsuario.setCorreo(request.getParameter("correo")); // Asigna el correo
                nuevoUsuario.setTelefono(request.getParameter("telefono")); // Asigna el teléfono
                nuevoUsuario.setPasswordHash(request.getParameter("passwordHash")); // Asigna la contraseña o hash
                nuevoUsuario.setFotoCedula(request.getParameter("fotoCedula")); // Asigna la foto de cédula

                String fechaNacimiento = request.getParameter("fechaNacimiento"); // Obtiene la fecha como texto
                if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) { // Valida que sí haya fecha
                    nuevoUsuario.setFechaNacimiento(Date.valueOf(fechaNacimiento)); // Convierte texto a Date
                }

                nuevoUsuario.setEstado(request.getParameter("estado")); // Asigna el estado
                nuevoUsuario.setRol(request.getParameter("rol")); // Asigna el rol

                int idUsuarioGenerado = dao.registrar(nuevoUsuario); // Registra usuario y obtien el ID generado

                if (idUsuarioGenerado > 0 && "Cliente".equals(nuevoUsuario.getRol())) { // Si se registró usuario cliente
                    response.sendRedirect("registrarCliente.jsp?idUsuario=" + idUsuarioGenerado); // Envía idUsuario al formulario cliente
                } else if (idUsuarioGenerado > 0 && "Prestador".equals(nuevoUsuario.getRol())) { // Si se registró usuario prestador
                    response.sendRedirect("registrarProveedor.jsp?idUsuario=" + idUsuarioGenerado); // Envía idUsuario al formulario proveedor
                } else { // Si hubo error
                    response.sendRedirect("index.jsp"); // Vuelve al registro
                }
                break; // Termina este caso

            case "actualizar": // Acción para actualizar un usuario existente
                Usuario usuarioActualizado = new Usuario(); // Crea un objeto Usuario vacío

                usuarioActualizado.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); // Asigna el id
                usuarioActualizado.setNombre(request.getParameter("nombre")); // Asigna el nombre
                usuarioActualizado.setFotoPerfil(request.getParameter("fotoPerfil")); // Asigna la foto de perfil
                usuarioActualizado.setCorreo(request.getParameter("correo")); // Asigna el correo
                usuarioActualizado.setTelefono(request.getParameter("telefono")); // Asigna el teléfono
                usuarioActualizado.setPasswordHash(request.getParameter("passwordHash")); // Asigna la contraseña o hash
                usuarioActualizado.setFotoCedula(request.getParameter("fotoCedula")); // Asigna la foto de cédula

                String fechaNacimientoAct = request.getParameter("fechaNacimiento"); // Obtiene la fecha como texto
                if (fechaNacimientoAct != null && !fechaNacimientoAct.isEmpty()) { // Valida que sí haya fecha
                    usuarioActualizado.setFechaNacimiento(Date.valueOf(fechaNacimientoAct)); // Convierte texto a Date
                }

                usuarioActualizado.setEstado(request.getParameter("estado")); // Asigna el estado
                usuarioActualizado.setRol(request.getParameter("rol")); // Asigna el rol

                dao.actualizar(usuarioActualizado); // Actualiza el usuario con el DAO

                response.sendRedirect("UsuarioServlet?accion=listar"); // Redirige a la lista de usuarios
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("index.jsp"); // Redirige al inicio
                break; // Termina este caso
        }
    }
}
