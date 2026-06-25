<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva JSP que indica contenido HTML y codificación UTF-8 --%>

<%@page import="java.util.List"%> <%-- Importa List para trabajar con listas --%>

<%@page import="com.mycompany.proyectosenaweb.modelo.Proveedor"%> <%-- Importa la clase Proveedor del paquete modelo --%>

<!DOCTYPE html> <%-- Indica al navegador que el documento es HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera de la página --%>

    <meta charset="UTF-8"> <%-- Permite mostrar tildes, ñ y caracteres especiales --%>

    <title>Lista de Proveedores</title> <%-- Título de la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal con estilos CSS --%>

        <h1>Lista de Proveedores</h1> <%-- Título principal de la página --%>

        <a class="boton" href="registrarProveedor.jsp">Registrar nuevo proveedor</a> <%-- Enlace para registrar proveedor --%>

        <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para regresar al menú principal --%>

        <br><br> <%-- Saltos de línea para separar botones de la tabla --%>

        <table> <%-- Inicio de tabla --%>

            <thead> <%-- Inicio del encabezado de la tabla --%>

                <tr> <%-- Fila del encabezado --%>
                    <th>ID Proveedor</th> <%-- Columna para id_proveedor --%>
                    <th>ID Usuario</th> <%-- Columna para id_usuario --%>
                    <th>Foto Personal</th> <%-- Columna para foto personal --%>
                    <th>Estado Validación</th> <%-- Columna para estado de validación --%>
                    <th>Acciones</th> <%-- Columna para editar y eliminar --%>
                </tr> <%-- Fin de la fila del encabezado --%>

            </thead> <%-- Fin del encabezado --%>

            <tbody> <%-- Inicio del cuerpo de la tabla --%>

                <%
                    // Recupera la lista de proveedores enviada desde ProveedorServlet
                    List<Proveedor> listaProveedores = (List<Proveedor>) request.getAttribute("listaProveedores");

                    // Verifica si la lista no existe o está vacía
                    if (listaProveedores == null || listaProveedores.isEmpty()) {
                %>

                    <tr> <%-- Fila para mostrar mensaje cuando no hay proveedores --%>
                        <td colspan="5">No hay proveedores registrados</td> <%-- Mensaje ocupando todas las columnas --%>
                    </tr> <%-- Fin de la fila --%>

                <%
                    // Si la lista sí contiene proveedores
                    } else {

                        // Recorre cada proveedor de la lista
                        for (Proveedor proveedor : listaProveedores) {
                %>

                    <tr> <%-- Inicio de fila por cada proveedor --%>

                        <td><%= proveedor.getIdProveedor() %></td> <%-- Muestra el id del proveedor --%>

                        <td><%= proveedor.getIdUsuario() %></td> <%-- Muestra el id del usuario asociado --%>

                        <td><%= proveedor.getFotoPersonal() %></td> <%-- Muestra la foto personal o ruta guardada --%>

                        <td><%= proveedor.getEstadoValidacion() %></td> <%-- Muestra el estado de validación --%>

                        <td> <%-- Inicio de columna de acciones --%>

                            <a href="ProveedorServlet?accion=editar&id=<%= proveedor.getIdProveedor() %>">Editar</a> <%-- Enlace para editar proveedor --%>

                            | <%-- Separador visual --%>

                            <a href="ProveedorServlet?accion=eliminar&id=<%= proveedor.getIdProveedor() %>"
                               onclick="return confirm('¿Está seguro de eliminar este proveedor?');">Eliminar</a> <%-- Enlace para eliminar proveedor con confirmación --%>

                        </td> <%-- Fin de columna de acciones --%>

                    </tr> <%-- Fin de la fila del proveedor --%>

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