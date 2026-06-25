package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase AutenticacionBiometrica

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class AutenticacionBiometrica { // Declara la clase AutenticacionBiometrica, que representa la tabla autenticacion_biometrica

    private int idBiometria; // Guarda el identificador único del registro biométrico
    private int idUsuario; // Guarda el id del usuario relacionado con la autenticación biométrica
    private String tipo; // Guarda el tipo de autenticación biométrica: Huella o Facial
    private String hashDatoBiometrico; // Guarda el hash del dato biométrico, no el dato real directamente
    private Timestamp fechaRegistro; // Guarda la fecha y hora en que se registró la biometría
    private boolean activa; // Indica si la autenticación biométrica está activa

    public AutenticacionBiometrica() { // Constructor vacío para crear un objeto sin datos iniciales
    } // Fin del constructor vacío

    public AutenticacionBiometrica(int idBiometria, int idUsuario, String tipo,
                                   String hashDatoBiometrico, Timestamp fechaRegistro,
                                   boolean activa) { // Constructor con todos los datos
        this.idBiometria = idBiometria; // Asigna el id recibido al atributo idBiometria
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.tipo = tipo; // Asigna el tipo recibido al atributo tipo
        this.hashDatoBiometrico = hashDatoBiometrico; // Asigna el hash biométrico recibido al atributo hashDatoBiometrico
        this.fechaRegistro = fechaRegistro; // Asigna la fecha de registro recibida al atributo fechaRegistro
        this.activa = activa; // Asigna el estado de actividad recibido al atributo activa
    } // Fin del constructor con parámetros

    public int getIdBiometria() { // Método para obtener el id de biometría
        return idBiometria; // Retorna el valor de idBiometria
    } // Fin del método getIdBiometria

    public void setIdBiometria(int idBiometria) { // Método para cambiar el id de biometría
        this.idBiometria = idBiometria; // Asigna el nuevo valor al atributo idBiometria
    } // Fin del método setIdBiometria

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getTipo() { // Método para obtener el tipo de biometría
        return tipo; // Retorna el valor de tipo
    } // Fin del método getTipo

    public void setTipo(String tipo) { // Método para cambiar el tipo de biometría
        this.tipo = tipo; // Asigna el nuevo valor al atributo tipo
    } // Fin del método setTipo

    public String getHashDatoBiometrico() { // Método para obtener el hash del dato biométrico
        return hashDatoBiometrico; // Retorna el valor de hashDatoBiometrico
    } // Fin del método getHashDatoBiometrico

    public void setHashDatoBiometrico(String hashDatoBiometrico) { // Método para cambiar el hash del dato biométrico
        this.hashDatoBiometrico = hashDatoBiometrico; // Asigna el nuevo valor al atributo hashDatoBiometrico
    } // Fin del método setHashDatoBiometrico

    public Timestamp getFechaRegistro() { // Método para obtener la fecha y hora de registro
        return fechaRegistro; // Retorna el valor de fechaRegistro
    } // Fin del método getFechaRegistro
    
    public void setFechaRegistro(Timestamp fechaRegistro) { // Método para cambiar la fecha y hora de registro
        this.fechaRegistro = fechaRegistro; // Asigna el nuevo valor al atributo fechaRegistro
    } // Fin del método setFechaRegistro

    public boolean isActiva() { // Método para saber si la biometría está activa
        return activa; // Retorna true si está activa o false si está inactiva
    } // Fin del método isActiva

    public void setActiva(boolean activa) { // Método para cambiar el estado de actividad
        this.activa = activa; // Asigna el nuevo valor al atributo activa
    } // Fin del método setActiva

} // Fin de la clase AutenticacionBiometrica
