package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Notificacion

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class Notificacion { // Declara la clase Notificacion, que representa la tabla notificaciones de la base de datos

    private int idNotificacion; // Guarda el identificador único de la notificación
    private int idUsuario; // Guarda el id del usuario que recibe la notificación
    private String contenido; // Guarda el texto o contenido de la notificación
    private String tipo; // Guarda el tipo de notificación
    private boolean leida; // Indica si la notificación ya fue leída
    private Timestamp fechaEnvio; // Guarda la fecha y hora en que se envió la notificación

    public Notificacion() { // Constructor vacío para crear un objeto Notificacion sin datos iniciales
    } // Fin del constructor vacío

    public Notificacion(int idNotificacion, int idUsuario, String contenido,
                        String tipo, boolean leida, Timestamp fechaEnvio) { // Constructor con todos los datos
        this.idNotificacion = idNotificacion; // Asigna el id recibido al atributo idNotificacion
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.contenido = contenido; // Asigna el contenido recibido al atributo contenido
        this.tipo = tipo; // Asigna el tipo recibido al atributo tipo
        this.leida = leida; // Asigna el estado de lectura recibido al atributo leida
        this.fechaEnvio = fechaEnvio; // Asigna la fecha de envío recibida al atributo fechaEnvio
    } // Fin del constructor con parámetros

    public int getIdNotificacion() { // Método para obtener el id de la notificación
        return idNotificacion; // Retorna el valor de idNotificacion
    } // Fin del método getIdNotificacion

    public void setIdNotificacion(int idNotificacion) { // Método para cambiar el id de la notificación
        this.idNotificacion = idNotificacion; // Asigna el nuevo valor al atributo idNotificacion
    } // Fin del método setIdNotificacion

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getContenido() { // Método para obtener el contenido de la notificación
        return contenido; // Retorna el valor de contenido
    } // Fin del método getContenido

    public void setContenido(String contenido) { // Método para cambiar el contenido de la notificación
        this.contenido = contenido; // Asigna el nuevo valor al atributo contenido
    } // Fin del método setContenido

    public String getTipo() { // Método para obtener el tipo de notificación
        return tipo; // Retorna el valor de tipo
    } // Fin del método getTipo

    public void setTipo(String tipo) { // Método para cambiar el tipo de notificación
        this.tipo = tipo; // Asigna el nuevo valor al atributo tipo
    } // Fin del método setTipo

    public boolean isLeida() { // Método para saber si la notificación fue leída
        return leida; // Retorna true si fue leída o false si no fue leída
    } // Fin del método isLeida

    public void setLeida(boolean leida) { // Método para cambiar el estado de lectura de la notificación
        this.leida = leida; // Asigna el nuevo valor al atributo leida
    } // Fin del método setLeida

    public Timestamp getFechaEnvio() { // Método para obtener la fecha y hora de envío
        return fechaEnvio; // Retorna el valor de fechaEnvio
    } // Fin del método getFechaEnvio

    public void setFechaEnvio(Timestamp fechaEnvio) { // Método para cambiar la fecha y hora de envío
        this.fechaEnvio = fechaEnvio; // Asigna el nuevo valor al atributo fechaEnvio
    } // Fin del método setFechaEnvio

} // Fin de la clase Notificacion