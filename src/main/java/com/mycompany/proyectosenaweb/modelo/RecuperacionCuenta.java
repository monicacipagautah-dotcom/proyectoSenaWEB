package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase RecuperacionCuenta

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class RecuperacionCuenta { // Declara la clase RecuperacionCuenta, que representa la tabla recuperacion_cuenta

    private int idRecuperacion; // Guarda el identificador único del registro de recuperación
    private int idUsuario; // Guarda el id del usuario que solicitó la recuperación
    private String correoAlternativo; // Guarda el correo alternativo para recuperar la cuenta
    private String telefonoAlternativo; // Guarda el teléfono alternativo para recuperar la cuenta
    private String codigoVerificacion; // Guarda el código de verificación enviado al usuario
    private boolean usado; // Indica si el código de recuperación ya fue usado
    private Timestamp fechaCreacion; // Guarda la fecha y hora en que se creó el código
    private Timestamp fechaExpiracion; // Guarda la fecha y hora en que expira el código

    public RecuperacionCuenta() { // Constructor vacío para crear un objeto RecuperacionCuenta sin datos iniciales
    } // Fin del constructor vacío

    public RecuperacionCuenta(int idRecuperacion, int idUsuario, String correoAlternativo,
                              String telefonoAlternativo, String codigoVerificacion,
                              boolean usado, Timestamp fechaCreacion,
                              Timestamp fechaExpiracion) { // Constructor con todos los datos
        this.idRecuperacion = idRecuperacion; // Asigna el id recibido al atributo idRecuperacion
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.correoAlternativo = correoAlternativo; // Asigna el correo alternativo recibido al atributo correoAlternativo
        this.telefonoAlternativo = telefonoAlternativo; // Asigna el teléfono alternativo recibido al atributo telefonoAlternativo
        this.codigoVerificacion = codigoVerificacion; // Asigna el código recibido al atributo codigoVerificacion
        this.usado = usado; // Asigna el estado de uso recibido al atributo usado
        this.fechaCreacion = fechaCreacion; // Asigna la fecha de creación recibida al atributo fechaCreacion
        this.fechaExpiracion = fechaExpiracion; // Asigna la fecha de expiración recibida al atributo fechaExpiracion
    } // Fin del constructor con parámetros

    public int getIdRecuperacion() { // Método para obtener el id de recuperación
        return idRecuperacion; // Retorna el valor de idRecuperacion
    } // Fin del método getIdRecuperacion

    public void setIdRecuperacion(int idRecuperacion) { // Método para cambiar el id de recuperación
        this.idRecuperacion = idRecuperacion; // Asigna el nuevo valor al atributo idRecuperacion
    } // Fin del método setIdRecuperacion

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getCorreoAlternativo() { // Método para obtener el correo alternativo
        return correoAlternativo; // Retorna el valor de correoAlternativo
    } // Fin del método getCorreoAlternativo

    public void setCorreoAlternativo(String correoAlternativo) { // Método para cambiar el correo alternativo
        this.correoAlternativo = correoAlternativo; // Asigna el nuevo valor al atributo correoAlternativo
    } // Fin del método setCorreoAlternativo
    
    public String getTelefonoAlternativo() { // Método para obtener el teléfono alternativo
        return telefonoAlternativo; // Retorna el valor de telefonoAlternativo
    } // Fin del método getTelefonoAlternativo

    public void setTelefonoAlternativo(String telefonoAlternativo) { // Método para cambiar el teléfono alternativo
        this.telefonoAlternativo = telefonoAlternativo; // Asigna el nuevo valor al atributo telefonoAlternativo
    } // Fin del método setTelefonoAlternativo

    public String getCodigoVerificacion() { // Método para obtener el código de verificación
        return codigoVerificacion; // Retorna el valor de codigoVerificacion
    } // Fin del método getCodigoVerificacion

    public void setCodigoVerificacion(String codigoVerificacion) { // Método para cambiar el código de verificación
        this.codigoVerificacion = codigoVerificacion; // Asigna el nuevo valor al atributo codigoVerificacion
    } // Fin del método setCodigoVerificacion

    public boolean isUsado() { // Método para saber si el código ya fue usado
        return usado; // Retorna true si fue usado o false si no fue usado
    } // Fin del método isUsado

    public void setUsado(boolean usado) { // Método para cambiar el estado de uso del código
        this.usado = usado; // Asigna el nuevo valor al atributo usado
    } // Fin del método setUsado

    public Timestamp getFechaCreacion() { // Método para obtener la fecha y hora de creación
        return fechaCreacion; // Retorna el valor de fechaCreacion
    } // Fin del método getFechaCreacion

    public void setFechaCreacion(Timestamp fechaCreacion) { // Método para cambiar la fecha y hora de creación
        this.fechaCreacion = fechaCreacion; // Asigna el nuevo valor al atributo fechaCreacion
    } // Fin del método setFechaCreacion

    public Timestamp getFechaExpiracion() { // Método para obtener la fecha y hora de expiración
        return fechaExpiracion; // Retorna el valor de fechaExpiracion
    } // Fin del método getFechaExpiracion

    public void setFechaExpiracion(Timestamp fechaExpiracion) { // Método para cambiar la fecha y hora de expiración
        this.fechaExpiracion = fechaExpiracion; // Asigna el nuevo valor al atributo fechaExpiracion
    } // Fin del método setFechaExpiracion

} // Fin de la clase RecuperacionCuenta