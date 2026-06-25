package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase ProveedorPreferido

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class ProveedorPreferido { // Declara la clase ProveedorPreferido, que representa la tabla proveedores_preferidos

    private int idPreferido; // Guarda el identificador único del proveedor preferido
    private int idCliente; // Guarda el id del cliente que agregó el proveedor como preferido
    private int idProveedor; // Guarda el id del proveedor que fue agregado como preferido
    private String descripcion; // Guarda una descripción del proveedor preferido
    private Timestamp fechaAgregado; // Guarda la fecha y hora en que se agregó como preferido
    private String notas; // Guarda notas adicionales sobre el proveedor preferido

    public ProveedorPreferido() { // Constructor vacío para crear un objeto sin datos iniciales
    } // Fin del constructor vacío

    public ProveedorPreferido(int idPreferido, int idCliente, int idProveedor,String descripcion, Timestamp fechaAgregado,
                              String notas) { // Constructor con todos los datos
        
        this.idPreferido = idPreferido; // Asigna el id recibido al atributo idPreferido
        this.idCliente = idCliente; // Asigna el id del cliente recibido al atributo idCliente
        this.idProveedor = idProveedor; // Asigna el id del proveedor recibido al atributo idProveedor
        this.descripcion = descripcion; // Asigna la descripción recibida al atributo descripcion
        this.fechaAgregado = fechaAgregado; // Asigna la fecha de agregado recibida al atributo fechaAgregado
        this.notas = notas; // Asigna las notas recibidas al atributo notas
    } // Fin del constructor con parámetros

    public int getIdPreferido() { // Método para obtener el id del proveedor preferido
        return idPreferido; // Retorna el valor de idPreferido
    } // Fin del método getIdPreferido

    public void setIdPreferido(int idPreferido) { // Método para cambiar el id del proveedor preferido
        this.idPreferido = idPreferido; // Asigna el nuevo valor al atributo idPreferido
    } // Fin del método setIdPreferido

    public int getIdCliente() { // Método para obtener el id del cliente
        return idCliente; // Retorna el valor de idCliente
    } // Fin del método getIdCliente

    public void setIdCliente(int idCliente) { // Método para cambiar el id del cliente
        this.idCliente = idCliente; // Asigna el nuevo valor al atributo idCliente
    } // Fin del método setIdCliente

    public int getIdProveedor() { // Método para obtener el id del proveedor
        return idProveedor; // Retorna el valor de idProveedor
    } // Fin del método getIdProveedor

    public void setIdProveedor(int idProveedor) { // Método para cambiar el id del proveedor
        this.idProveedor = idProveedor; // Asigna el nuevo valor al atributo idProveedor
    } // Fin del método setIdProveedor

    public String getDescripcion() { // Método para obtener la descripción
        return descripcion; // Retorna el valor de descripcion
    } // Fin del método getDescripcion

    public void setDescripcion(String descripcion) { // Método para cambiar la descripción
        this.descripcion = descripcion; // Asigna el nuevo valor al atributo descripcion
    } // Fin del método setDescripcion

    public Timestamp getFechaAgregado() { // Método para obtener la fecha y hora de agregado
        return fechaAgregado; // Retorna el valor de fechaAgregado
    } // Fin del método getFechaAgregado

    public void setFechaAgregado(Timestamp fechaAgregado) { // Método para cambiar la fecha y hora de agregado
        this.fechaAgregado = fechaAgregado; // Asigna el nuevo valor al atributo fechaAgregado
    } // Fin del método setFechaAgregado

    public String getNotas() { // Método para obtener las notas
        return notas; // Retorna el valor de notas
    } // Fin del método getNotas

    public void setNotas(String notas) { // Método para cambiar las notas
        this.notas = notas; // Asigna el nuevo valor al atributo notas
    } // Fin del método setNotas

} // Fin de la clase ProveedorPreferido
