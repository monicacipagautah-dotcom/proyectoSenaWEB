package com.mycompany.proyectosenaweb.servlet; // Define el paquete donde está el Servlet

import com.mycompany.proyectosenaweb.dao.servicioDAO; // Importa el DAO de Servicio
import com.mycompany.proyectosenaweb.modelo.Servicio; // Importa el modelo Servicio
import jakarta.servlet.ServletException; // Permite manejar errores propios de Servlet
import jakarta.servlet.annotation.WebServlet; // Permite definir la URL del Servlet con anotación
import jakarta.servlet.http.HttpServlet; // Clase base para crear Servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Permite recibir datos enviados por formularios o URL
import jakarta.servlet.http.HttpServletResponse; // Permite enviar respuestas o redirecciones al navegador
import java.io.IOException; // Permite manejar errores de entrada y salida
import java.sql.Date; // Permite convertir texto a fecha SQL
import java.sql.Time; // Permite convertir texto a hora SQL

@WebServlet("/ServicioServlet") // Define la URL con la que se llamará este Servlet
public class ServicioServlet extends HttpServlet { // Clase encargada de controlar las acciones de servicios

    private final servicioDAO dao = new servicioDAO(); // Crea un objeto DAO para consultar la base de datos

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende solicitudes GET

        String accion = request.getParameter("accion"); // Obtiene la acción enviada por la URL

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("menu.jsp"); // Redirige al menú principal
            return; // Termina el método
        }

        switch (accion) { // Evalúa la acción recibida

            case "listar": // Acción para listar servicios
                request.setAttribute("listaServicios", dao.listar()); // Envía la lista de servicios al JSP
                request.getRequestDispatcher("listarServicios.jsp").forward(request, response); // Muestra la vista de listado
                break; // Termina este caso

            case "editar": // Acción para buscar un servicio y mostrarlo en formulario de edición
                int idEditar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                Servicio servicioEditar = dao.buscarPorId(idEditar); // Busca el servicio por id
                request.setAttribute("servicio", servicioEditar); // Envía el servicio encontrado al JSP
                request.getRequestDispatcher("editarServicio.jsp").forward(request, response); // Abre el JSP de edición
                break; // Termina este caso

            case "eliminar": // Acción para eliminar un servicio
                int idEliminar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                dao.eliminar(idEliminar); // Elimina el servicio en la base de datos
                response.sendRedirect("ServicioServlet?accion=listar"); // Redirige al listado de servicios
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("menu.jsp"); // Redirige al menú
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

            case "guardar": // Acción para guardar un nuevo servicio
                Servicio nuevoServicio = new Servicio(); // Crea un objeto Servicio vacío

                nuevoServicio.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); // Asigna el id del cliente

                String idProveedor = request.getParameter("idProveedor"); // Obtiene el id del proveedor como texto
                if (idProveedor != null && !idProveedor.isEmpty()) { // Verifica si se escribió proveedor
                    nuevoServicio.setIdProveedor(Integer.parseInt(idProveedor)); // Asigna el id del proveedor
                } else { // Si no se escribió proveedor
                    nuevoServicio.setIdProveedor(null); // Deja el proveedor como null
                }

                nuevoServicio.setTipo(request.getParameter("tipo")); // Asigna el tipo de servicio
                nuevoServicio.setFecha(Date.valueOf(request.getParameter("fecha"))); // Convierte y asigna la fecha
                nuevoServicio.setHora(Time.valueOf(request.getParameter("hora") + ":00")); // Convierte y asigna la hora
                nuevoServicio.setDireccion(request.getParameter("direccion")); // Asigna la dirección
                nuevoServicio.setEstado(request.getParameter("estado")); // Asigna el estado

                dao.registrar(nuevoServicio); // Guarda el servicio en la base de datos

                response.sendRedirect("ServicioServlet?accion=listar"); // Redirige al listado de servicios
                break; // Termina este caso

            case "actualizar": // Acción para actualizar un servicio existente
                Servicio servicioActualizado = new Servicio(); // Crea un objeto Servicio vacío

                servicioActualizado.setIdServicio(Integer.parseInt(request.getParameter("idServicio"))); // Asigna el id del servicio
                servicioActualizado.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); // Asigna el id del cliente

                String idProveedorAct = request.getParameter("idProveedor"); // Obtiene el proveedor como texto
                if (idProveedorAct != null && !idProveedorAct.isEmpty()) { // Verifica si se escribió proveedor
                    servicioActualizado.setIdProveedor(Integer.parseInt(idProveedorAct)); // Asigna proveedor
                } else { // Si no se escribió proveedor
                    servicioActualizado.setIdProveedor(null); // Deja proveedor null
                }

                servicioActualizado.setTipo(request.getParameter("tipo")); // Asigna el tipo
                servicioActualizado.setFecha(Date.valueOf(request.getParameter("fecha"))); // Asigna la fecha
                servicioActualizado.setHora(Time.valueOf(request.getParameter("hora") + ":00")); // Asigna la hora
                servicioActualizado.setDireccion(request.getParameter("direccion")); // Asigna la dirección
                servicioActualizado.setEstado(request.getParameter("estado")); // Asigna el estado

                dao.actualizar(servicioActualizado); // Actualiza el servicio en la base de datos

                response.sendRedirect("ServicioServlet?accion=listar"); // Redirige al listado
                break; // Termina este caso

            default: // Si la acción no es válida
                response.sendRedirect("menu.jsp"); // Redirige al menú
                break; // Termina este caso
        }
    }
}