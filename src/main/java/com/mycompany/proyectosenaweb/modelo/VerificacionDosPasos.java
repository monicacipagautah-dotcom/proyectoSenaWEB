package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase VerificacionDosPasos

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class VerificacionDosPasos { // Declara la clase VerificacionDosPasos, que representa la tabla verificacion_dos_pasos

    private int idVerificacion; // Guarda el identificador único de la verificación
    private int idUsuario; // Guarda el id del usuario relacionado con la verificación
    private String canal; // Guarda el canal usado para enviar el código: Correo o SMS
    private String codigo; // Guarda el código de verificación enviado al usuario
    private Timestamp fechaEnvio; // Guarda la fecha y hora en que se envió el código
    private boolean verificado; // Indica si el código ya fue verificado correctamente
    private Timestamp fechaExpiracion; // Guarda la fecha y hora en que expira el código

    public VerificacionDosPasos() { // Constructor vacío para crear un objeto VerificacionDosPasos sin datos iniciales
    } // Fin del constructor vacío

    public VerificacionDosPasos(int idVerificacion, int idUsuario, String canal,
                                String codigo, Timestamp fechaEnvio,
                                boolean verificado, Timestamp fechaExpiracion) { // Constructor con todos los datos
        this.idVerificacion = idVerificacion; // Asigna el id recibido al atributo idVerificacion
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.canal = canal; // Asigna el canal recibido al atributo canal
        this.codigo = codigo; // Asigna el código recibido al atributo codigo
        this.fechaEnvio = fechaEnvio; // Asigna la fecha de envío recibida al atributo fechaEnvio
        this.verificado = verificado; // Asigna el estado de verificación recibido al atributo verificado
        this.fechaExpiracion = fechaExpiracion; // Asigna la fecha de expiración recibida al atributo fechaExpiracion
    } // Fin del constructor con parámetros

    public int getIdVerificacion() { // Método para obtener el id de la verificación
        return idVerificacion; // Retorna el valor de idVerificacion
    } // Fin del método getIdVerificacion

    public void setIdVerificacion(int idVerificacion) { // Método para cambiar el id de la verificación
        this.idVerificacion = idVerificacion; // Asigna el nuevo valor al atributo idVerificacion
    } // Fin del método setIdVerificacion

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getCanal() { // Método para obtener el canal de verificación
        return canal; // Retorna el valor de canal
    } // Fin del método getCanal

    public void setCanal(String canal) { // Método para cambiar el canal de verificación
        this.canal = canal; // Asigna el nuevo valor al atributo canal
    } // Fin del método setCanal

    public String getCodigo() { // Método para obtener el código de verificación
        return codigo; // Retorna el valor de codigo
    } // Fin del método getCodigo

    public void setCodigo(String codigo) { // Método para cambiar el código de verificación
        this.codigo = codigo; // Asigna el nuevo valor al atributo codigo
    } // Fin del método setCodigo

    public Timestamp getFechaEnvio() { // Método para obtener la fecha y hora de envío
        return fechaEnvio; // Retorna el valor de fechaEnvio
    } // Fin del método getFechaEnvio
    
    public void setFechaEnvio(Timestamp fechaEnvio) { // Método para cambiar la fecha y hora de envío
        this.fechaEnvio = fechaEnvio; // Asigna el nuevo valor al atributo fechaEnvio
    } // Fin del método setFechaEnvio

    public boolean isVerificado() { // Método para saber si el código fue verificado
        return verificado; // Retorna true si fue verificado o false si no fue verificado
    } // Fin del método isVerificado

    public void setVerificado(boolean verificado) { // Método para cambiar el estado de verificación
        this.verificado = verificado; // Asigna el nuevo valor al atributo verificado
    } // Fin del método setVerificado

    public Timestamp getFechaExpiracion() { // Método para obtener la fecha y hora de expiración
        return fechaExpiracion; // Retorna el valor de fechaExpiracion
    } // Fin del método getFechaExpiracion

    public void setFechaExpiracion(Timestamp fechaExpiracion) { // Método para cambiar la fecha y hora de expiración
        this.fechaExpiracion = fechaExpiracion; // Asigna el nuevo valor al atributo fechaExpiracion
    } // Fin del método setFechaExpiracion

} // Fin de la clase VerificacionDosPasos