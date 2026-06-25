<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>
<%
    String idUsuarioRecibido = request.getParameter("idUsuario"); // Recibe el idUsuario desde la URL
%>
<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Registrar Proveedor</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Registrar Proveedor</h1> <%-- Título principal de la página --%>

        <form action="ProveedorServlet" method="post"> <%-- Formulario que envía los datos al ProveedorServlet usando POST --%>

            <input type="hidden" name="accion" value="guardar"> <%-- Campo oculto que indica al Servlet que debe guardar --%>

            <label>ID Usuario:</label> <%-- Etiqueta para el id del usuario --%>
            <input type="number" name="idUsuario" value="<%= idUsuarioRecibido != null ? idUsuarioRecibido : ""%>" readonly required> <%-- Muestra el idUsuario automático y no permite modificarlo --%>
            <br><br> <%-- Separación visual --%>

            <label>Foto personal:</label> <%-- Etiqueta para la foto personal --%>
            <input type="text" name="fotoPersonal"> <%-- Campo para escribir ruta, nombre o URL de la foto personal --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <label>Estado de validación:</label> <%-- Etiqueta para el estado de validación --%>
            <select name="estadoValidacion" required> <%-- Lista desplegable para seleccionar estado de validación --%>
                <option value="Pendiente">Pendiente</option> <%-- Opción Pendiente --%>
                <option value="Aprobado">Aprobado</option> <%-- Opción Aprobado --%>
                <option value="Rechazado">Rechazado</option> <%-- Opción Rechazado --%>
            </select> <%-- Fin de la lista desplegable --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <button type="submit">Guardar Proveedor</button> <%-- Botón que envía el formulario --%>

            <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para volver al menú principal --%>

            <a class="boton" href="ProveedorServlet?accion=listar">Ver proveedores</a> <%-- Enlace para listar proveedores --%>

        </form> <%-- Fin del formulario --%>

    </div> <%-- Fin del contenedor principal --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>