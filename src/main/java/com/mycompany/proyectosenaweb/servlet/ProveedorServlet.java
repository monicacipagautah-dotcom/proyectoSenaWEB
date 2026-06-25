package com.mycompany.proyectosenaweb.servlet; // Define el paquete donde se encuentra el Servlet

import com.mycompany.proyectosenaweb.dao.ProveedorDAO; // Importa el DAO de Proveedor
import com.mycompany.proyectosenaweb.modelo.Proveedor; // Importa el modelo Proveedor
import jakarta.servlet.ServletException; // Permite manejar errores propios de Servlets
import jakarta.servlet.annotation.WebServlet; // Permite definir la ruta del Servlet con anotación
import jakarta.servlet.http.HttpServlet; // Clase base para crear Servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Permite recibir datos enviados por formularios o URL
import jakarta.servlet.http.HttpServletResponse; // Permite enviar respuestas o redirecciones al navegador
import java.io.IOException; // Permite manejar errores de entrada y salida

@WebServlet("/ProveedorServlet") // Define la URL con la que se llamará este Servlet
public class ProveedorServlet extends HttpServlet { // Clase encargada de controlar las acciones de proveedores

    private final ProveedorDAO dao = new ProveedorDAO(); // Crea un objeto DAO para manejar consultas de proveedores

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende solicitudes GET

        String accion = request.getParameter("accion"); // Obtiene la acción enviada por la URL

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("menu.jsp"); // Redirige al menú principal
            return; // Termina el método
        }

        switch (accion) { // Evalúa la acción recibida

            case "listar": // Acción para listar proveedores
                request.setAttribute("listaProveedores", dao.listar()); // Envía la lista de proveedores al JSP
                request.getRequestDispatcher("listarProveedores.jsp").forward(request, response); // Abre la vista de listado
                break; // Termina este caso

            case "editar": // Acción para buscar un proveedor y editarlo
                int idEditar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                Proveedor proveedorEditar = dao.buscarPorId(idEditar); // Busca el proveedor por id
                request.setAttribute("proveedor", proveedorEditar); // Envía el proveedor encontrado al JSP
                request.getRequestDispatcher("editarProveedor.jsp").forward(request, response); // Abre la vista de edición
                break; // Termina este caso

            case "eliminar": // Acción para eliminar un proveedor
                int idEliminar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                dao.eliminar(idEliminar); // Elimina el proveedor en la base de datos
                response.sendRedirect("ProveedorServlet?accion=listar"); // Redirige al listado de proveedores
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("menu.jsp"); // Redirige al menú principal
                break; // Termina este caso
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende solicitudes POST

        request.setCharacterEncoding("UTF-8"); // Permite recibir tildes, ñ y caracteres especiales

        String accion = request.getParameter("accion"); // Obtiene la acción enviada desde el formulario

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("menu.jsp"); // Redirige al menú principal
            return; // Termina el método
        }

        switch (accion) { // Evalúa la acción recibida

            case "guardar": // Acción para registrar un nuevo proveedor
                Proveedor nuevoProveedor = new Proveedor(); // Crea un objeto Proveedor vacío

                nuevoProveedor.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); // Asigna el id del usuario
                nuevoProveedor.setFotoPersonal(request.getParameter("fotoPersonal")); // Asigna la foto personal
                nuevoProveedor.setEstadoValidacion(request.getParameter("estadoValidacion")); // Asigna el estado de validación

                dao.registrar(nuevoProveedor); // Guarda el proveedor en la base de datos

                response.sendRedirect("ProveedorServlet?accion=listar"); // Redirige al listado de proveedores
                break; // Termina este caso

            case "actualizar": // Acción para actualizar un proveedor existente
                Proveedor proveedorActualizado = new Proveedor(); // Crea un objeto Proveedor vacío

                proveedorActualizado.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor"))); // Asigna el id del proveedor
                proveedorActualizado.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); // Asigna el id del usuario
                proveedorActualizado.setFotoPersonal(request.getParameter("fotoPersonal")); // Asigna la foto personal
                proveedorActualizado.setEstadoValidacion(request.getParameter("estadoValidacion")); // Asigna el estado de validación

                dao.actualizar(proveedorActualizado); // Actualiza el proveedor en la base de datos

                response.sendRedirect("ProveedorServlet?accion=listar"); // Redirige al listado de proveedores
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("menu.jsp"); // Redirige al menú principal
                break; // Termina este caso
        }
    }
}