<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="java.util.List"%> <%-- Importa List para trabajar con listas --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Servicio"%> <%-- Importa la clase Servicio del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento es HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera --%>

    <meta charset="UTF-8"> <%-- Permite tildes, ñ y caracteres especiales --%>

    <title>Lista de Servicios</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal con diseño CSS --%>

        <h1>Lista de Servicios</h1> <%-- Título principal de la página --%>

        <a class="boton" href="registrarServicio.jsp">Registrar nuevo servicio</a> <%-- Enlace para registrar servicio --%>

        <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para regresar al menú --%>

        <br><br> <%-- Saltos de línea para separar los botones de la tabla --%>

        <table> <%-- Inicio de la tabla donde se muestran los servicios --%>

            <thead> <%-- Inicio del encabezado de la tabla --%>

                <tr> <%-- Fila del encabezado --%>
                    <th>ID Servicio</th> <%-- Columna para el id del servicio --%>
                    <th>ID Cliente</th> <%-- Columna para el id del cliente --%>
                    <th>ID Proveedor</th> <%-- Columna para el id del proveedor --%>
                    <th>Tipo</th> <%-- Columna para el tipo de servicio --%>
                    <th>Fecha</th> <%-- Columna para la fecha --%>
                    <th>Hora</th> <%-- Columna para la hora --%>
                    <th>Dirección</th> <%-- Columna para la dirección --%>
                    <th>Estado</th> <%-- Columna para el estado --%>
                    <th>Acciones</th> <%-- Columna para editar y eliminar --%>
                </tr> <%-- Fin de la fila del encabezado --%>

            </thead> <%-- Fin del encabezado --%>

            <tbody> <%-- Inicio del cuerpo de la tabla --%>

                <%
                    // Recupera la lista de servicios enviada desde el Servlet
                    List<Servicio> listaServicios = (List<Servicio>) request.getAttribute("listaServicios");

                    // Verifica si la lista no existe o está vacía
                    if (listaServicios == null || listaServicios.isEmpty()) {
                %>

                    <tr> <%-- Fila para mostrar mensaje cuando no hay datos --%>
                        <td colspan="9">No hay servicios registrados</td> <%-- Mensaje ocupando todas las columnas --%>
                    </tr> <%-- Fin de la fila --%>

                <%
                    // Si la lista sí tiene servicios
                    } else {

                        // Recorre cada servicio recibido
                        for (Servicio servicio : listaServicios) {
                %>

                    <tr> <%-- Inicio de una fila por cada servicio --%>

                        <td><%= servicio.getIdServicio() %></td> <%-- Muestra el id del servicio --%>

                        <td><%= servicio.getIdCliente() %></td> <%-- Muestra el id del cliente --%>

                        <td><%= servicio.getIdProveedor() != null ? servicio.getIdProveedor() : "Sin proveedor" %></td> <%-- Muestra proveedor o texto si es null --%>

                        <td><%= servicio.getTipo() %></td> <%-- Muestra el tipo de servicio --%>

                        <td><%= servicio.getFecha() %></td> <%-- Muestra la fecha del servicio --%>

                        <td><%= servicio.getHora() %></td> <%-- Muestra la hora del servicio --%>

                        <td><%= servicio.getDireccion() %></td> <%-- Muestra la dirección del servicio --%>

                        <td><%= servicio.getEstado() %></td> <%-- Muestra el estado del servicio --%>

                        <td> <%-- Inicio de la columna de acciones --%>

                            <a href="ServicioServlet?accion=editar&id=<%= servicio.getIdServicio() %>">Editar</a> <%-- Enlace para editar --%>

                            | <%-- Separador visual --%>

                            <a href="ServicioServlet?accion=eliminar&id=<%= servicio.getIdServicio() %>"
                               onclick="return confirm('¿Está seguro de eliminar este servicio?');">Eliminar</a> <%-- Enlace para eliminar con confirmación --%>

                        </td> <%-- Fin de la columna de acciones --%>

                    </tr> <%-- Fin de la fila del servicio --%>

                <%
                        // Cierra el for
                        }

                    // Cierra el else
                    }
                %>

            </tbody> <%-- Fin del cuerpo de la tabla --%>

        </table> <%-- Fin de la tabla --%>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>