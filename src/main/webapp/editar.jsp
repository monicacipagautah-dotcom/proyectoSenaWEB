<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Configura esta página JSP para usar UTF-8 --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Usuario"%> <%-- Importa la clase Usuario del paquete modelo --%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Editar Usuario</title> <%-- Título que aparece en la pestaña del navegador --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <h1>Editar Usuario</h1> <%-- Título principal visible para el usuario --%>

    <%
        // Recupera el objeto usuario enviado desde el Servlet
        Usuario usuario = (Usuario) request.getAttribute("usuario");

        // Verifica si no se recibió ningún usuario
        if (usuario == null) {
    %>

        <p>No se encontró el usuario para editar.</p> <%-- Mensaje cuando el usuario no existe --%>

        <a href="UsuarioServlet?accion=listar">Volver a la lista</a> <%-- Enlace para regresar a la lista --%>

    <%
        // Si el usuario sí existe, se muestra el formulario
        } else {
    %>

        <form action="UsuarioServlet" method="post"> <%-- Formulario que envía los datos actualizados al Servlet --%>

            <input type="hidden" name="accion" value="actualizar"> <%-- Indica al Servlet que debe actualizar --%>

            <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>"> <%-- Envía oculto el id del usuario --%>

            <label>Nombre:</label> <%-- Etiqueta del campo nombre --%>
            <input type="text" name="nombre" value="<%= usuario.getNombre() %>" required> <%-- Campo para editar el nombre --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Foto de perfil:</label> <%-- Etiqueta del campo foto de perfil --%>
            <input type="text" name="fotoPerfil" value="<%= usuario.getFotoPerfil() != null ? usuario.getFotoPerfil() : "" %>"> <%-- Campo para editar la foto de perfil --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Correo:</label> <%-- Etiqueta del campo correo --%>
            <input type="email" name="correo" value="<%= usuario.getCorreo() %>" required> <%-- Campo para editar el correo --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Teléfono:</label> <%-- Etiqueta del campo teléfono --%>
            <input type="text" name="telefono" value="<%= usuario.getTelefono() %>" required> <%-- Campo para editar el teléfono --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Contraseña:</label> <%-- Etiqueta del campo contraseña --%>
            <input type="password" name="passwordHash" value="<%= usuario.getPasswordHash() %>" required> <%-- Campo para editar la contraseña o hash --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Foto de cédula:</label> <%-- Etiqueta del campo foto de cédula --%>
            <input type="text" name="fotoCedula" value="<%= usuario.getFotoCedula() != null ? usuario.getFotoCedula() : "" %>"> <%-- Campo para editar la foto de cédula --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Fecha de nacimiento:</label> <%-- Etiqueta del campo fecha de nacimiento --%>
            <input type="date" name="fechaNacimiento" value="<%= usuario.getFechaNacimiento() != null ? usuario.getFechaNacimiento() : "" %>"> <%-- Campo para editar la fecha --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Estado:</label> <%-- Etiqueta del campo estado --%>
            <select name="estado" required> <%-- Lista desplegable para editar el estado --%>
                <option value="Pendiente" <%= "Pendiente".equals(usuario.getEstado()) ? "selected" : "" %>>Pendiente</option> <%-- Selecciona Pendiente si coincide --%>
                <option value="Activo" <%= "Activo".equals(usuario.getEstado()) ? "selected" : "" %>>Activo</option> <%-- Selecciona Activo si coincide --%>
                <option value="Rechazado" <%= "Rechazado".equals(usuario.getEstado()) ? "selected" : "" %>>Rechazado</option> <%-- Selecciona Rechazado si coincide --%>
                <option value="Eliminado" <%= "Eliminado".equals(usuario.getEstado()) ? "selected" : "" %>>Eliminado</option> <%-- Selecciona Eliminado si coincide --%>
            </select> <%-- Fin del select estado --%>
            <br><br> <%-- Saltos de línea --%>

            <label>Rol:</label> <%-- Etiqueta del campo rol --%>
            <select name="rol" required> <%-- Lista desplegable para editar el rol --%>
                <option value="Cliente" <%= "Cliente".equals(usuario.getRol()) ? "selected" : "" %>>Cliente</option> <%-- Selecciona Cliente si coincide --%>
                <option value="Prestador" <%= "Prestador".equals(usuario.getRol()) ? "selected" : "" %>>Prestador</option> <%-- Selecciona Prestador si coincide --%>
            </select> <%-- Fin del select rol --%>
            <br><br> <%-- Saltos de línea --%>

            <button type="submit">Actualizar Usuario</button> <%-- Botón para enviar la actualización --%>

        </form> <%-- Fin del formulario --%>

        <br> <%-- Salto de línea --%>

        <a href="UsuarioServlet?accion=listar">Volver a la lista</a> <%-- Enlace para regresar a la lista de usuarios --%>

    <%
        // Cierra el else
        }
    %>

</body> <%-- Fin del cuerpo visible de la página --%>

</html> <%-- Fin del documento HTML --%>