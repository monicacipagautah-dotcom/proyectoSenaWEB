<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Configura la página JSP con codificación UTF-8 --%>

<%@page import="java.util.List"%> <%-- Importa List para manejar listas de usuarios --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Usuario"%> <%-- Importa la clase Usuario del paquete modelo --%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar tildes, ñ y caracteres especiales --%>

    <title>Lista de Usuarios</title> <%-- Título de la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal para aplicar estilos CSS --%>

        <h1>Lista de Usuarios</h1> <%-- Título principal de la página --%>

        <a class="boton" href="index.jsp">Registrar nuevo usuario</a> <%-- Enlace para abrir el formulario de registro --%>

        <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para regresar al menú principal --%>

        <br><br> <%-- Saltos de línea para separar botones de la tabla --%>

        <table> <%-- Inicio de la tabla de usuarios --%>

            <thead> <%-- Inicio del encabezado de la tabla --%>

                <tr> <%-- Fila del encabezado --%>
                    <th>ID</th> <%-- Columna para id del usuario --%>
                    <th>Nombre</th> <%-- Columna para nombre --%>
                    <th>Foto Perfil</th> <%-- Columna para foto de perfil --%>
                    <th>Correo</th> <%-- Columna para correo --%>
                    <th>Teléfono</th> <%-- Columna para teléfono --%>
                    <th>Contraseña</th> <%-- Columna para contraseña ocultada --%>
                    <th>Foto Cédula</th> <%-- Columna para foto de cédula --%>
                    <th>Fecha Nacimiento</th> <%-- Columna para fecha de nacimiento --%>
                    <th>Estado</th> <%-- Columna para estado --%>
                    <th>Rol</th> <%-- Columna para rol --%>
                    <th>Acciones</th> <%-- Columna para editar y eliminar --%>
                </tr> <%-- Fin de la fila del encabezado --%>

            </thead> <%-- Fin del encabezado --%>

            <tbody> <%-- Inicio del cuerpo de la tabla --%>

                <%
                    // Recupera la lista de usuarios enviada desde UsuarioServlet
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");

                    // Verifica si la lista no existe o está vacía
                    if (listaUsuarios == null || listaUsuarios.isEmpty()) {
                %>

                    <tr> <%-- Fila para mostrar mensaje cuando no hay usuarios --%>
                        <td colspan="11">No hay usuarios registrados</td> <%-- Mensaje ocupando todas las columnas --%>
                    </tr> <%-- Fin de la fila --%>

                <%
                    // Si la lista sí contiene usuarios
                    } else {

                        // Recorre cada usuario de la lista
                        for (Usuario usuario : listaUsuarios) {
                %>

                    <tr> <%-- Inicio de fila por cada usuario --%>

                        <td><%= usuario.getIdUsuario() %></td> <%-- Muestra el id del usuario --%>

                        <td><%= usuario.getNombre() %></td> <%-- Muestra el nombre --%>

                        <td><%= usuario.getFotoPerfil() %></td> <%-- Muestra la foto de perfil o nombre/ruta guardada --%>

                        <td><%= usuario.getCorreo() %></td> <%-- Muestra el correo --%>

                        <td><%= usuario.getTelefono() %></td> <%-- Muestra el teléfono --%>

                        <td>****</td> <%-- Oculta la contraseña por seguridad --%>

                        <td><%= usuario.getFotoCedula() %></td> <%-- Muestra la foto de cédula o nombre/ruta guardada --%>

                        <td><%= usuario.getFechaNacimiento() %></td> <%-- Muestra la fecha de nacimiento --%>

                        <td><%= usuario.getEstado() %></td> <%-- Muestra el estado --%>

                        <td><%= usuario.getRol() %></td> <%-- Muestra el rol --%>

                        <td> <%-- Inicio de columna de acciones --%>

                            <a href="UsuarioServlet?accion=editar&id=<%= usuario.getIdUsuario() %>">Editar</a> <%-- Enlace para editar usuario --%>

                            | <%-- Separador visual --%>

                            <a href="UsuarioServlet?accion=eliminar&id=<%= usuario.getIdUsuario() %>"
                               onclick="return confirm('¿Está seguro de eliminar este usuario?');">Eliminar</a> <%-- Enlace para eliminar usuario con confirmación --%>

                        </td> <%-- Fin de columna acciones --%>

                    </tr> <%-- Fin de fila usuario --%>

                <%
                        // Cierra el ciclo for
                        }

                    // Cierra el else
                    }
                %>

            </tbody> <%-- Fin del cuerpo de la tabla --%>

        </table> <%-- Fin de la tabla --%>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>