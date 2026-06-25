<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Proveedor"%> <%-- Importa la clase Proveedor del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Editar Proveedor</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Editar Proveedor</h1> <%-- Título principal de la página --%>

        <%
            // Recupera el objeto proveedor enviado desde el Servlet
            Proveedor proveedor = (Proveedor) request.getAttribute("proveedor");

            // Verifica si no se recibió ningún proveedor
            if (proveedor == null) {
        %>

            <p>No se encontró el proveedor para editar.</p> <%-- Mensaje cuando el proveedor no existe --%>

            <a class="boton" href="ProveedorServlet?accion=listar">Volver a la lista</a> <%-- Enlace para volver al listado --%>

        <%
            // Si el proveedor sí existe, se muestra el formulario
            } else {
        %>

            <form action="ProveedorServlet" method="post"> <%-- Formulario que envía datos actualizados al Servlet --%>

                <input type="hidden" name="accion" value="actualizar"> <%-- Campo oculto que indica que se actualizará --%>

                <input type="hidden" name="idProveedor" value="<%= proveedor.getIdProveedor() %>"> <%-- Envía oculto el id del proveedor --%>

                <label>ID Usuario:</label> <%-- Etiqueta para id_usuario --%>
                <input type="number" name="idUsuario" value="<%= proveedor.getIdUsuario() %>" required> <%-- Campo para editar id_usuario --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Foto personal:</label> <%-- Etiqueta para foto personal --%>
                <input type="text" name="fotoPersonal" value="<%= proveedor.getFotoPersonal() != null ? proveedor.getFotoPersonal() : "" %>"> <%-- Campo para editar foto personal --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Estado de validación:</label> <%-- Etiqueta para estado de validación --%>
                <select name="estadoValidacion" required> <%-- Lista desplegable para editar estado --%>
                    <option value="Pendiente" <%= "Pendiente".equals(proveedor.getEstadoValidacion()) ? "selected" : "" %>>Pendiente</option> <%-- Selecciona Pendiente si coincide --%>
                    <option value="Aprobado" <%= "Aprobado".equals(proveedor.getEstadoValidacion()) ? "selected" : "" %>>Aprobado</option> <%-- Selecciona Aprobado si coincide --%>
                    <option value="Rechazado" <%= "Rechazado".equals(proveedor.getEstadoValidacion()) ? "selected" : "" %>>Rechazado</option> <%-- Selecciona Rechazado si coincide --%>
                </select> <%-- Fin del select --%>
                <br><br> <%-- Saltos de línea --%>

                <button type="submit">Actualizar Proveedor</button> <%-- Botón para enviar los cambios --%>

                <a class="boton" href="ProveedorServlet?accion=listar">Volver a la lista</a> <%-- Enlace para regresar al listado --%>

            </form> <%-- Fin del formulario --%>

        <%
            // Cierra el else
            }
        %>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>