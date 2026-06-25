<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Servicio"%> <%-- Importa la clase Servicio del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Editar Servicio</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos --%>

        <h1>Editar Servicio</h1> <%-- Título principal de la página --%>

        <%
            // Recupera el objeto servicio enviado desde el Servlet
            Servicio servicio = (Servicio) request.getAttribute("servicio");

            // Verifica si no se recibió ningún servicio
            if (servicio == null) {
        %>

            <p>No se encontró el servicio para editar.</p> <%-- Mensaje cuando el servicio no existe --%>

            <a class="boton" href="ServicioServlet?accion=listar">Volver a la lista</a> <%-- Enlace para volver al listado --%>

        <%
            // Si el servicio sí existe, se muestra el formulario
            } else {
        %>

            <form action="ServicioServlet" method="post"> <%-- Formulario que envía los datos actualizados al Servlet --%>

                <input type="hidden" name="accion" value="actualizar"> <%-- Campo oculto que indica que se actualizará --%>

                <input type="hidden" name="idServicio" value="<%= servicio.getIdServicio() %>"> <%-- Envía el id del servicio oculto --%>

                <label>ID Cliente:</label> <%-- Etiqueta para el id del cliente --%>
                <input type="number" name="idCliente" value="<%= servicio.getIdCliente() %>" required> <%-- Campo para editar el id del cliente --%>
                <br><br> <%-- Saltos de línea --%>

                <label>ID Proveedor:</label> <%-- Etiqueta para el id del proveedor --%>
                <input type="number" name="idProveedor" value="<%= servicio.getIdProveedor() != null ? servicio.getIdProveedor() : "" %>"> <%-- Campo opcional para editar proveedor --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Tipo de servicio:</label> <%-- Etiqueta para el tipo de servicio --%>
                <input type="text" name="tipo" value="<%= servicio.getTipo() %>" required> <%-- Campo para editar el tipo --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Fecha:</label> <%-- Etiqueta para la fecha --%>
                <input type="date" name="fecha" value="<%= servicio.getFecha() %>" required> <%-- Campo para editar la fecha --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Hora:</label> <%-- Etiqueta para la hora --%>
                <input type="time" name="hora" value="<%= servicio.getHora() %>" required> <%-- Campo para editar la hora --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Dirección:</label> <%-- Etiqueta para la dirección --%>
                <input type="text" name="direccion" value="<%= servicio.getDireccion() %>" required> <%-- Campo para editar la dirección --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Estado:</label> <%-- Etiqueta para el estado --%>
                <select name="estado" required> <%-- Lista desplegable para editar estado --%>
                    <option value="Pendiente" <%= "Pendiente".equals(servicio.getEstado()) ? "selected" : "" %>>Pendiente</option> <%-- Selecciona Pendiente si coincide --%>
                    <option value="Confirmado" <%= "Confirmado".equals(servicio.getEstado()) ? "selected" : "" %>>Confirmado</option> <%-- Selecciona Confirmado si coincide --%>
                    <option value="Cancelado" <%= "Cancelado".equals(servicio.getEstado()) ? "selected" : "" %>>Cancelado</option> <%-- Selecciona Cancelado si coincide --%>
                    <option value="Finalizado" <%= "Finalizado".equals(servicio.getEstado()) ? "selected" : "" %>>Finalizado</option> <%-- Selecciona Finalizado si coincide --%>
                </select> <%-- Fin del select estado --%>
                <br><br> <%-- Saltos de línea --%>

                <button type="submit">Actualizar Servicio</button> <%-- Botón para guardar cambios --%>

                <a class="boton" href="ServicioServlet?accion=listar">Volver a la lista</a> <%-- Enlace para regresar al listado --%>

            </form> <%-- Fin del formulario --%>

        <%
            // Cierra el else
            }
        %>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>
