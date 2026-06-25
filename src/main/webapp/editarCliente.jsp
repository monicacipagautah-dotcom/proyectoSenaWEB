<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Cliente"%> <%-- Importa la clase Cliente del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Editar Cliente</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Editar Cliente</h1> <%-- Título principal de la página --%>

        <%
            // Recupera el objeto cliente enviado desde el Servlet
            Cliente cliente = (Cliente) request.getAttribute("cliente");

            // Verifica si no se recibió ningún cliente
            if (cliente == null) {
        %>

            <p>No se encontró el cliente para editar.</p> <%-- Mensaje cuando el cliente no existe --%>

            <a class="boton" href="ClienteServlet?accion=listar">Volver a la lista</a> <%-- Enlace para volver al listado --%>

        <%
            // Si el cliente sí existe, se muestra el formulario
            } else {
        %>

            <form action="ClienteServlet" method="post"> <%-- Formulario que envía datos actualizados al Servlet --%>

                <input type="hidden" name="accion" value="actualizar"> <%-- Campo oculto que indica que se actualizará --%>

                <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>"> <%-- Envía oculto el id del cliente --%>

                <label>ID Usuario:</label> <%-- Etiqueta para id_usuario --%>
                <input type="number" name="idUsuario" value="<%= cliente.getIdUsuario() %>" required> <%-- Campo para editar id_usuario --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Biografía:</label> <%-- Etiqueta para biografía --%>
                <input type="text" name="biografia" value="<%= cliente.getBiografia() != null ? cliente.getBiografia() : "" %>"> <%-- Campo para editar biografía --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Intenciones:</label> <%-- Etiqueta para intenciones --%>
                <input type="text" name="intenciones" value="<%= cliente.getIntenciones() != null ? cliente.getIntenciones() : "" %>"> <%-- Campo para editar intenciones --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Número de contactos:</label> <%-- Etiqueta para número de contactos --%>
                <input type="number" name="numeroContactos" value="<%= cliente.getNumeroContactos() %>" required> <%-- Campo para editar número de contactos --%>
                <br><br> <%-- Saltos de línea --%>

                <label>Dirección:</label> <%-- Etiqueta para dirección --%>
                <input type="text" name="direccion" value="<%= cliente.getDireccion() != null ? cliente.getDireccion() : "" %>"> <%-- Campo para editar dirección --%>
                <br><br> <%-- Saltos de línea --%>

                <button type="submit">Actualizar Cliente</button> <%-- Botón para enviar los cambios --%>

                <a class="boton" href="ClienteServlet?accion=listar">Volver a la lista</a> <%-- Enlace para regresar al listado --%>

            </form> <%-- Fin del formulario --%>

        <%
            // Cierra el else
            }
        %>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>