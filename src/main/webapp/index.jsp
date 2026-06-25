<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%
    // Obtiene el rol enviado por la URL, por ejemplo: index.jsp?rol=Cliente
    String rolSeleccionado = request.getParameter("rol");

    // Si no llega ningún rol, se deja Cliente como valor por defecto
    if (rolSeleccionado == null || rolSeleccionado.isEmpty()) {
        rolSeleccionado = "Cliente";
    }

    // Define el título que se mostrará según el rol seleccionado
    String tituloRegistro = "Prestador".equals(rolSeleccionado) ? "Registro de Proveedor" : "Registro de Cliente";
%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar tildes, ñ y caracteres especiales --%>

    <title><%= tituloRegistro %></title> <%-- Muestra el título dinámico en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos --%>

        <h1><%= tituloRegistro %></h1> <%-- Título dinámico visible en la página --%>

        <form action="UsuarioServlet" method="post"> <%-- Formulario que envía los datos al UsuarioServlet --%>

            <input type="hidden" name="accion" value="guardar"> <%-- Campo oculto que indica que se guardará un usuario --%>

            <label>Nombre:</label> <%-- Etiqueta para el nombre --%>
            <input type="text" name="nombre" required> <%-- Campo para escribir el nombre --%>
            <br><br> <%-- Separación --%>

            <label>Foto de perfil:</label> <%-- Etiqueta para foto de perfil --%>
            <input type="text" name="fotoPerfil"> <%-- Campo para ruta, nombre o URL de foto de perfil --%>
            <br><br> <%-- Separación --%>

            <label>Correo:</label> <%-- Etiqueta para correo --%>
            <input type="email" name="correo" required> <%-- Campo para escribir correo electrónico --%>
            <br><br> <%-- Separación --%>

            <label>Teléfono:</label> <%-- Etiqueta para teléfono --%>
            <input type="text" name="telefono" required> <%-- Campo para escribir teléfono --%>
            <br><br> <%-- Separación --%>

            <label>Contraseña:</label> <%-- Etiqueta para contraseña --%>
            <input type="password" name="passwordHash" required> <%-- Campo para escribir contraseña --%>
            <br><br> <%-- Separación --%>

            <label>Foto de cédula:</label> <%-- Etiqueta para foto de cédula --%>
            <input type="text" name="fotoCedula"> <%-- Campo para ruta, nombre o URL de foto de cédula --%>
            <br><br> <%-- Separación --%>

            <label>Fecha de nacimiento:</label> <%-- Etiqueta para fecha de nacimiento --%>
            <input type="date" name="fechaNacimiento"> <%-- Campo para seleccionar fecha de nacimiento --%>
            <br><br> <%-- Separación --%>

            <label>Estado:</label> <%-- Etiqueta para estado --%>
            <select name="estado" required> <%-- Lista desplegable para estado --%>
                <option value="Pendiente">Pendiente</option> <%-- Estado inicial recomendado --%>
                <option value="Activo">Activo</option> <%-- Estado activo --%>
                <option value="Rechazado">Rechazado</option> <%-- Estado rechazado --%>
                <option value="Eliminado">Eliminado</option> <%-- Estado eliminado --%>
            </select> <%-- Fin select estado --%>
            <br><br> <%-- Separación --%>

            <label>Rol:</label> <%-- Etiqueta para rol --%>
            <select name="rol" required> <%-- Lista desplegable para rol --%>
                <option value="Cliente" <%= "Cliente".equals(rolSeleccionado) ? "selected" : "" %>>Cliente</option> <%-- Selecciona Cliente si viene por URL --%>
                <option value="Prestador" <%= "Prestador".equals(rolSeleccionado) ? "selected" : "" %>>Prestador</option> <%-- Selecciona Prestador si viene por URL --%>
            </select> <%-- Fin select rol --%>
            <br><br> <%-- Separación --%>

            <button type="submit">Registrar</button> <%-- Botón para enviar formulario --%>

            <a class="boton" href="login.jsp">Volver al login</a> <%-- Enlace para volver al login --%>

        </form> <%-- Fin formulario --%>

    </div> <%-- Fin contenedor --%>

</body> <%-- Fin cuerpo --%>

</html> <%-- Fin documento HTML --%>