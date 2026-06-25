<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica que la página genera HTML y usa codificación UTF-8 --%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Iniciar Sesión</title> <%-- Título que aparece en la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo de estilos CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Iniciar Sesión</h1> <%-- Título principal de la página --%>

        <form action="LoginServlet" method="post"> <%-- Formulario que envía correo y contraseña al LoginServlet --%>

            <label>Correo:</label> <%-- Etiqueta para el campo correo --%>
            <input type="email" name="correo" required> <%-- Campo para escribir correo; required lo hace obligatorio --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <label>Contraseña:</label> <%-- Etiqueta para el campo contraseña --%>
            <input type="password" name="passwordHash" required> <%-- Campo para contraseña; oculta el texto ingresado --%>
            <br><br> <%-- Saltos de línea para separar campos --%>

            <button type="submit">Ingresar</button> <%-- Botón para enviar el formulario e iniciar sesión --%>

        </form> <%-- Fin del formulario de login --%>

        <hr> <%-- Línea horizontal para separar login de registro --%>

        <h2>Registrarse</h2> <%-- Título de la sección de registro --%>

        <p>Seleccione el tipo de usuario que desea registrar:</p> <%-- Instrucción para el usuario --%>

        <a class="boton" href="index.jsp?rol=Cliente">Registrarse como Cliente</a> <%-- Enlace al registro con rol Cliente seleccionado --%>

        <a class="boton" href="index.jsp?rol=Prestador">Registrarse como Proveedor</a> <%-- Enlace al registro con rol Prestador seleccionado --%>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>