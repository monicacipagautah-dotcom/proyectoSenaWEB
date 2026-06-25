package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Chat

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class Chat { // Declara la clase Chat, que representa la tabla chats de la base de datos

    private int idChat; // Guarda el identificador único del chat
    private int idCliente; // Guarda el id del cliente que participa en el chat
    private int idProveedor; // Guarda el id del proveedor que participa en el chat
    private int idServicio; // Guarda el id del servicio relacionado con el chat
    private Timestamp fechaCreacion; // Guarda la fecha y hora en que se creó el chat

    public Chat() { // Constructor vacío para crear un objeto Chat sin datos iniciales
    } // Fin del constructor vacío

    public Chat(int idChat, int idCliente, int idProveedor, int idServicio,
                Timestamp fechaCreacion) { // Constructor con todos los datos del chat
        this.idChat = idChat; // Asigna el id recibido al atributo idChat
        this.idCliente = idCliente; // Asigna el id del cliente recibido al atributo idCliente
        this.idProveedor = idProveedor; // Asigna el id del proveedor recibido al atributo idProveedor
        this.idServicio = idServicio; // Asigna el id del servicio recibido al atributo idServicio
        this.fechaCreacion = fechaCreacion; // Asigna la fecha de creación recibida al atributo fechaCreacion
    } // Fin del constructor con parámetros

    public int getIdChat() { // Método para obtener el id del chat
        return idChat; // Retorna el valor de idChat
    } // Fin del método getIdChat

    public void setIdChat(int idChat) { // Método para cambiar el id del chat
        this.idChat = idChat; // Asigna el nuevo valor al atributo idChat
    } // Fin del método setIdChat

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

    public int getIdServicio() { // Método para obtener el id del servicio
        return idServicio; // Retorna el valor de idServicio
    } // Fin del método getIdServicio

    public void setIdServicio(int idServicio) { // Método para cambiar el id del servicio
        this.idServicio = idServicio; // Asigna el nuevo valor al atributo idServicio
    } // Fin del método setIdServicio

    public Timestamp getFechaCreacion() { // Método para obtener la fecha de creación del chat
        return fechaCreacion; // Retorna el valor de fechaCreacion
    } // Fin del método getFechaCreacion

    public void setFechaCreacion(Timestamp fechaCreacion) { // Método para cambiar la fecha de creación del chat
        this.fechaCreacion = fechaCreacion; // Asigna el nuevo valor al atributo fechaCreacion
    } // Fin del método setFechaCreacion

} // Fin de la clase Chat