package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Mensaje

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class Mensaje { // Declara la clase Mensaje, que representa la tabla mensajes de la base de datos

    private int idMensaje; // Guarda el identificador único del mensaje
    private int idChat; // Guarda el id del chat al que pertenece el mensaje
    private int idUsuario; // Guarda el id del usuario que envió el mensaje
    private String contenido; // Guarda el contenido o texto del mensaje
    private Timestamp fechaEnvio; // Guarda la fecha y hora en que se envió el mensaje
    private boolean leido; // Indica si el mensaje ya fue leído

    public Mensaje() { // Constructor vacío para crear un objeto Mensaje sin datos iniciales
    } // Fin del constructor vacío

    public Mensaje(int idMensaje, int idChat, int idUsuario, String contenido,
                   Timestamp fechaEnvio, boolean leido) { // Constructor con todos los datos del mensaje
        this.idMensaje = idMensaje; // Asigna el id recibido al atributo idMensaje
        this.idChat = idChat; // Asigna el id del chat recibido al atributo idChat
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.contenido = contenido; // Asigna el contenido recibido al atributo contenido
        this.fechaEnvio = fechaEnvio; // Asigna la fecha de envío recibida al atributo fechaEnvio
        this.leido = leido; // Asigna el estado de lectura recibido al atributo leido
    } // Fin del constructor con parámetros

    public int getIdMensaje() { // Método para obtener el id del mensaje
        return idMensaje; // Retorna el valor de idMensaje
    } // Fin del método getIdMensaje

    public void setIdMensaje(int idMensaje) { // Método para cambiar el id del mensaje
        this.idMensaje = idMensaje; // Asigna el nuevo valor al atributo idMensaje
    } // Fin del método setIdMensaje

    public int getIdChat() { // Método para obtener el id del chat
        return idChat; // Retorna el valor de idChat
    } // Fin del método getIdChat

    public void setIdChat(int idChat) { // Método para cambiar el id del chat
        this.idChat = idChat; // Asigna el nuevo valor al atributo idChat
    } // Fin del método setIdChat

    public int getIdUsuario() { // Método para obtener el id del usuario que envió el mensaje
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario que envió el mensaje
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getContenido() { // Método para obtener el contenido del mensaje
        return contenido; // Retorna el valor de contenido
    } // Fin del método getContenido

    public void setContenido(String contenido) { // Método para cambiar el contenido del mensaje
        this.contenido = contenido; // Asigna el nuevo valor al atributo contenido
    } // Fin del método setContenido

    public Timestamp getFechaEnvio() { // Método para obtener la fecha y hora de envío
        return fechaEnvio; // Retorna el valor de fechaEnvio
    } // Fin del método getFechaEnvio

    public void setFechaEnvio(Timestamp fechaEnvio) { // Método para cambiar la fecha y hora de envío
        this.fechaEnvio = fechaEnvio; // Asigna el nuevo valor al atributo fechaEnvio
    } // Fin del método setFechaEnvio

    public boolean isLeido() { // Método para saber si el mensaje fue leído
        return leido; // Retorna true si fue leído o false si no fue leído
    } // Fin del método isLeido

    public void setLeido(boolean leido) { // Método para cambiar el estado de lectura del mensaje
        this.leido = leido; // Asigna el nuevo valor al atributo leido
    } // Fin del método setLeido

} // Fin de la clase Mensaje
