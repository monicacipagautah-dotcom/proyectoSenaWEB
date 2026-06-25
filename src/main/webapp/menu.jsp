<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica que la página genera contenido HTML y usa codificación UTF-8 --%>

<!DOCTYPE html> <%-- Indica al navegador que este documento usa la versión HTML5 --%>

<html> <%-- Etiqueta principal que contiene todo el documento HTML --%>

<head> <%-- Inicio de la cabecera; aquí van configuraciones que no se muestran directamente en la página --%>

    <meta charset="UTF-8"> <%-- Define la codificación UTF-8 para mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Menú Principal</title> <%-- Texto que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta esta página con el archivo de estilos ubicado en la carpeta css --%>

</head> <%-- Fin de la cabecera del documento --%>

<body> <%-- Inicio del cuerpo; aquí va todo lo que el usuario ve en la página --%>

    <div class="contenedor"> <%-- Crea un bloque principal con la clase contenedor para aplicar estilos desde CSS --%>

        <h1>Proyecto SENA Web</h1> <%-- Título principal que identifica el sistema web --%>

        <p>Seleccione una opción del sistema:</p> <%-- Párrafo con una instrucción para el usuario --%>

        <a class="boton" href="index.jsp">Registrar Usuario</a> <%-- Enlace con estilo de botón que lleva al formulario para registrar usuarios --%>

        <a class="boton" href="UsuarioServlet?accion=listar">Listar Usuarios</a> <%-- Enlace que llama al Servlet UsuarioServlet y le envía la acción listar --%>

        <a class="boton" href="registrarServicio.jsp">Registrar Servicio</a> <%-- Enlace para abrir el formulario de registro de servicios --%>

        <a class="boton" href="ServicioServlet?accion=listar">Listar Servicios</a> <%-- Enlace que llama al Servlet ServicioServlet y le envía la acción listar --%>

        <a class="boton" href="login.jsp">Iniciar Sesión</a> <%-- Enlace con estilo de botón que lleva a la página de inicio de sesión --%>

    </div> <%-- Cierra el bloque principal del contenido --%>

</body> <%-- Fin del cuerpo visible de la página --%>

</html> <%-- Fin del documento HTML --%>