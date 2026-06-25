<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Configura la página JSP con codificación UTF-8 --%>

<%@page import="java.util.List"%> <%-- Importa List para trabajar con listas --%>

<%@page import="com.mycompany.proyectosenaweb.dao.ClienteDAO"%> <%-- Importa ClienteDAO para consultar clientes --%>

<%@page import="com.mycompany.proyectosenaweb.dao.ProveedorDAO"%> <%-- Importa ProveedorDAO para consultar proveedores --%>

<%
    ClienteDAO clienteDAO = new ClienteDAO(); // Crea un objeto ClienteDAO para consultar clientes en la base de datos

    ProveedorDAO proveedorDAO = new ProveedorDAO(); // Crea un objeto ProveedorDAO para consultar proveedores en la base de datos

    List<String[]> listaClientes = clienteDAO.listarConNombre(); // Carga clientes con id_cliente y nombre del usuario

    List<String[]> listaProveedores = proveedorDAO.listarConNombre(); // Carga proveedores con id_proveedor y nombre del usuario

    String idClienteRecibido = request.getParameter("idCliente"); // Recibe idCliente si viene desde otra página
%>

<!DOCTYPE html> <%-- Indica que el documento está escrito en HTML5 --%>

<html> <%-- Inicio del documento HTML --%>

<head> <%-- Inicio de la cabecera --%>

    <meta charset="UTF-8"> <%-- Permite mostrar correctamente tildes, ñ y caracteres especiales --%>

    <title>Registrar Servicio</title> <%-- Título de la pestaña del navegador --%>

    <link rel="stylesheet" href="css/estilos.css"> <%-- Conecta el archivo CSS --%>

</head> <%-- Fin de la cabecera --%>

<body> <%-- Inicio del cuerpo visible de la página --%>

    <div class="contenedor"> <%-- Contenedor principal con estilos CSS --%>

        <h1>Registrar Servicio</h1> <%-- Título principal de la página --%>

        <form action="ServicioServlet" method="post"> <%-- Formulario que envía los datos al ServicioServlet --%>

            <input type="hidden" name="accion" value="guardar"> <%-- Campo oculto que indica al Servlet la acción guardar --%>

            <label>Cliente:</label> <%-- Etiqueta para seleccionar cliente --%>

            <select name="idCliente" required> <%-- Lista desplegable que enviará el id_cliente real --%>

                <option value="">Seleccione un cliente</option> <%-- Opción inicial sin valor --%>

                <%
                    for (String[] cliente : listaClientes) { // Recorre clientes con id y nombre

                        String idCliente = cliente[0]; // Obtiene el id_cliente real

                        String nombreCliente = cliente[1]; // Obtiene el nombre visible del cliente

                        String seleccionado = ""; // Variable para marcar un cliente como seleccionado

                        if (idClienteRecibido != null && idClienteRecibido.equals(idCliente)) { // Verifica si viene un cliente desde URL
                            seleccionado = "selected"; // Marca ese cliente como seleccionado
                        }
                %>

                    <option value="<%= idCliente %>" <%= seleccionado %>><%= nombreCliente %></option> <%-- Muestra nombre, pero envía id_cliente --%>

                <%
                    } // Fin del for de clientes
                %>

            </select> <%-- Fin del select cliente --%>

            <br><br> <%-- Separación visual --%>

            <label>Proveedor:</label> <%-- Etiqueta para seleccionar proveedor --%>

            <select name="idProveedor"> <%-- Lista desplegable que enviará el id_proveedor real --%>

                <option value="">Sin proveedor asignado</option> <%-- Permite guardar NULL en id_proveedor --%>

                <%
                    for (String[] proveedor : listaProveedores) { // Recorre proveedores con id y nombre

                        String idProveedor = proveedor[0]; // Obtiene el id_proveedor real

                        String nombreProveedor = proveedor[1]; // Obtiene el nombre visible del proveedor
                %>

                    <option value="<%= idProveedor %>"><%= nombreProveedor %></option> <%-- Muestra nombre, pero envía id_proveedor --%>

                <%
                    } // Fin del for de proveedores
                %>

            </select> <%-- Fin del select proveedor --%>

            <br><br> <%-- Separación visual --%>

            <label>Tipo de servicio:</label> <%-- Etiqueta para tipo de servicio --%>
            <input type="text" name="tipo" required> <%-- Campo para escribir el tipo de servicio --%>
            <br><br> <%-- Separación visual --%>

            <label>Fecha:</label> <%-- Etiqueta para fecha --%>
            <input type="date" name="fecha" required> <%-- Campo para seleccionar la fecha del servicio --%>
            <br><br> <%-- Separación visual --%>

            <label>Hora:</label> <%-- Etiqueta para hora --%>
            <input type="time" name="hora" required> <%-- Campo para seleccionar la hora del servicio --%>
            <br><br> <%-- Separación visual --%>

            <label>Dirección:</label> <%-- Etiqueta para dirección --%>
            <input type="text" name="direccion" required> <%-- Campo para escribir la dirección del servicio --%>
            <br><br> <%-- Separación visual --%>

            <label>Estado:</label> <%-- Etiqueta para estado del servicio --%>

            <select name="estado" required> <%-- Lista desplegable de estados válidos según la base de datos --%>
                <option value="Pendiente">Pendiente</option> <%-- Estado Pendiente --%>
                <option value="Confirmado">Confirmado</option> <%-- Estado Confirmado --%>
                <option value="Cancelado">Cancelado</option> <%-- Estado Cancelado --%>
                <option value="Finalizado">Finalizado</option> <%-- Estado Finalizado --%>
            </select> <%-- Fin select estado --%>

            <br><br> <%-- Separación visual --%>

            <button type="submit">Guardar Servicio</button> <%-- Botón para enviar el formulario --%>

            <a class="boton" href="menu.jsp">Volver al menú</a> <%-- Enlace para regresar al menú principal --%>

            <a class="boton" href="ServicioServlet?accion=listar">Ver servicios</a> <%-- Enlace para listar servicios --%>

        </form> <%-- Fin del formulario --%>

    </div> <%-- Fin del contenedor --%>

</body> <%-- Fin del cuerpo visible --%>

</html> <%-- Fin del documento HTML --%>