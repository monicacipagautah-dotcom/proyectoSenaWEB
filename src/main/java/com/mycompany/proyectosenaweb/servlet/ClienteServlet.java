package com.mycompany.proyectosenaweb.servlet; // Define el paquete donde se encuentra el Servlet

import com.mycompany.proyectosenaweb.dao.ClienteDAO; // Importa el DAO de Cliente
import com.mycompany.proyectosenaweb.modelo.Cliente; // Importa el modelo Cliente
import jakarta.servlet.ServletException; // Permite manejar errores propios de Servlets
import jakarta.servlet.annotation.WebServlet; // Permite definir la ruta del Servlet con anotación
import jakarta.servlet.http.HttpServlet; // Clase base para crear Servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Permite recibir datos enviados por formularios o URL
import jakarta.servlet.http.HttpServletResponse; // Permite enviar respuestas o redirecciones al navegador
import java.io.IOException; // Permite manejar errores de entrada y salida

@WebServlet("/ClienteServlet") // Define la URL con la que se llamará este Servlet
public class ClienteServlet extends HttpServlet { // Clase encargada de controlar las acciones de clientes

    private final ClienteDAO dao = new ClienteDAO(); // Crea un objeto DAO para manejar consultas de clientes

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método que atiende solicitudes GET

        String accion = request.getParameter("accion"); // Obtiene la acción enviada por la URL

        if (accion == null) { // Verifica si no llegó ninguna acción
            response.sendRedirect("menu.jsp"); // Redirige al menú principal
            return; // Termina el método
        }

        switch (accion) { // Evalúa la acción recibida

            case "listar": // Acción para listar clientes
                request.setAttribute("listaClientes", dao.listar()); // Envía la lista de clientes al JSP
                request.getRequestDispatcher("listarClientes.jsp").forward(request, response); // Abre la vista de listado
                break; // Termina este caso

            case "editar": // Acción para buscar un cliente y editarlo
                int idEditar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                Cliente clienteEditar = dao.buscarPorId(idEditar); // Busca el cliente por id
                request.setAttribute("cliente", clienteEditar); // Envía el cliente encontrado al JSP
                request.getRequestDispatcher("editarCliente.jsp").forward(request, response); // Abre la vista de edición
                break; // Termina este caso

            case "eliminar": // Acción para eliminar un cliente
                int idEliminar = Integer.parseInt(request.getParameter("id")); // Convierte el id recibido a entero
                dao.eliminar(idEliminar); // Elimina el cliente en la base de datos
                response.sendRedirect("ClienteServlet?accion=listar"); // Redirige al listado de clientes
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

            case "guardar": // Acción para registrar un nuevo cliente
                Cliente nuevoCliente = new Cliente(); // Crea un objeto Cliente vacío

                nuevoCliente.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); // Asigna el id del usuario
                nuevoCliente.setBiografia(request.getParameter("biografia")); // Asigna la biografía
                nuevoCliente.setIntenciones(request.getParameter("intenciones")); // Asigna las intenciones
                nuevoCliente.setNumeroContactos(Integer.parseInt(request.getParameter("numeroContactos"))); // Asigna el número de contactos
                nuevoCliente.setDireccion(request.getParameter("direccion")); // Asigna la dirección

              int idClienteGenerado = dao.registrar(nuevoCliente); // Registra cliente y obtiene el id generado

               if (idClienteGenerado > 0) { // Verifica si se registró correctamente
                response.sendRedirect("registrarServicio.jsp?idCliente=" + idClienteGenerado); // Redirige a solicitar servicio
}                else { // Si hubo error
                 response.sendRedirect("registrarCliente.jsp"); // Vuelve al formulario de cliente
}
                break; // Termina este caso

            case "actualizar": // Acción para actualizar un cliente existente
                Cliente clienteActualizado = new Cliente(); // Crea un objeto Cliente vacío

                clienteActualizado.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); // Asigna el id del cliente
                clienteActualizado.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); // Asigna el id del usuario
                clienteActualizado.setBiografia(request.getParameter("biografia")); // Asigna la biografía
                clienteActualizado.setIntenciones(request.getParameter("intenciones")); // Asigna las intenciones
                clienteActualizado.setNumeroContactos(Integer.parseInt(request.getParameter("numeroContactos"))); // Asigna número de contactos
                clienteActualizado.setDireccion(request.getParameter("direccion")); // Asigna la dirección

                dao.actualizar(clienteActualizado); // Actualiza el cliente en la base de datos

                response.sendRedirect("ClienteServlet?accion=listar"); // Redirige al listado de clientes
                break; // Termina este caso

            default: // Si la acción no existe
                response.sendRedirect("menu.jsp"); // Redirige al menú principal
                break; // Termina este caso
        }
    }
}