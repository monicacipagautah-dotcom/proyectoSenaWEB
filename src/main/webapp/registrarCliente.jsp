<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>
<%
    String idUsuarioRecibido = request.getParameter("idUsuario"); // Recibe el idUsuario desde la URL
%>
<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Registrar Cliente</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Registrar Cliente</h1> <%-- Título principal de la página --%>

        <form action="ClienteServlet" method="post"> <%-- Formulario que envía los datos al ClienteServlet usando POST --%>

            <input type="hidden" name="accion" value="guardar"> <%-- Campo oculto que indica al Servlet que debe guardar --%>

            <label>ID Usuario:</label> <%-- Etiqueta para el id del usuario --%>
            <input type="number" name="idUsuario" value="<%= idUsuarioRecibido != null ? idUsuarioRecibido : ""%>" readonly required> <%-- Muestra el idUsuario automático y no permite modificarlo --%>
            <br><br> <%-- Separación visual --%>

            <label>Biografía:</label> <%-- Etiqueta para la biografía --%>
            <input type="text" name="biografia"> <%-- Campo para escribir una breve biografía del cliente --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <label>Intenciones:</label> <%-- Etiqueta para las intenciones --%>
            <input type="text" name="intenciones"> <%-- Campo para escribir las intenciones o necesidades del cliente --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <label>Número de contactos:</label> <%-- Etiqueta para el número de contactos --%>
            <input type="number" name="numeroContactos" value="0" required> <%-- Campo para escribir cantidad de contactos; por defecto inicia en 0 --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <label>Dirección:</label> <%-- Etiqueta para la dirección --%>
            <input type="text" name="direccion"> <%-- Campo para escribir la dirección del cliente --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <button type="submit">Guardar Cliente</button> <%-- Botón que envía el formulario --%>

            <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para volver al menú principal --%>

            <a class="boton" href="ClienteServlet?accion=listar">Ver clientes</a> <%-- Enlace para listar clientes --%>

        </form> <%-- Fin del formulario --%>

    </div> <%-- Fin del contenedor principal --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>