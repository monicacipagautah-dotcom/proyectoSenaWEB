<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="java.util.List"%> <%-- Importa List para trabajar con listas --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Cliente"%> <%-- Importa la clase Cliente del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento es HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar tildes, ñ y caracteres especiales --%>

    <title>Lista de Clientes</title> <%-- Título de la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal con estilos CSS --%>

        <h1>Lista de Clientes</h1> <%-- Título principal de la página --%>

        <a class="boton" href="registrarCliente.jsp">Registrar nuevo cliente</a> <%-- Enlace para registrar cliente --%>

        <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para regresar al menú principal --%>

        <br><br> <%-- Saltos de línea para separar botones de la tabla --%>

        <table> <%-- Inicio de tabla --%>

            <thead> <%-- Inicio del encabezado de la tabla --%>

                <tr> <%-- Fila del encabezado --%>
                    <th>ID Cliente</th> <%-- Columna para id_cliente --%>
                    <th>ID Usuario</th> <%-- Columna para id_usuario --%>
                    <th>Biografía</th> <%-- Columna para biografía --%>
                    <th>Intenciones</th> <%-- Columna para intenciones --%>
                    <th>Número Contactos</th> <%-- Columna para número de contactos --%>
                    <th>Dirección</th> <%-- Columna para dirección --%>
                    <th>Acciones</th> <%-- Columna para editar y eliminar --%>
                </tr> <%-- Fin de la fila del encabezado --%>

            </thead> <%-- Fin del encabezado --%>

            <tbody> <%-- Inicio del cuerpo de la tabla --%>

                <%
                    // Recupera la lista de clientes enviada desde ClienteServlet
                    List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");

                    // Verifica si la lista no existe o está vacía
                    if (listaClientes == null || listaClientes.isEmpty()) {
                %>

                    <tr> <%-- Fila para mostrar mensaje cuando no hay clientes --%>
                        <td colspan="7">No hay clientes registrados</td> <%-- Mensaje ocupando todas las columnas --%>
                    </tr> <%-- Fin de la fila --%>

                <%
                    // Si la lista sí contiene clientes
                    } else {

                        // Recorre cada cliente de la lista
                        for (Cliente cliente : listaClientes) {
                %>

                    <tr> <%-- Inicio de fila por cada cliente --%>

                        <td><%= cliente.getIdCliente() %></td> <%-- Muestra el id del cliente --%>

                        <td><%= cliente.getIdUsuario() %></td> <%-- Muestra el id del usuario asociado --%>

                        <td><%= cliente.getBiografia() %></td> <%-- Muestra la biografía --%>

                        <td><%= cliente.getIntenciones() %></td> <%-- Muestra las intenciones --%>

                        <td><%= cliente.getNumeroContactos() %></td> <%-- Muestra el número de contactos --%>

                        <td><%= cliente.getDireccion() %></td> <%-- Muestra la dirección --%>

                        <td> <%-- Inicio de columna de acciones --%>

                            <a href="ClienteServlet?accion=editar&id=<%= cliente.getIdCliente() %>">Editar</a> <%-- Enlace para editar cliente --%>

                            | <%-- Separador visual --%>

                            <a href="ClienteServlet?accion=eliminar&id=<%= cliente.getIdCliente() %>"
                               onclick="return confirm('¿Está seguro de eliminar este cliente?');">Eliminar</a> <%-- Enlace para eliminar cliente con confirmación --%>

                        </td> <%-- Fin de columna de acciones --%>

                    </tr> <%-- Fin de la fila del cliente --%>

                <%
                        // Cierra el ciclo for
                        }

                    // Cierra el else
                    }
                %>

            </tbody> <%-- Fin del cuerpo de la tabla --%>

        </table> <%-- Fin de tabla --%>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>