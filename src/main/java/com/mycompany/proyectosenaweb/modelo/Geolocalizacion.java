package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Geolocalizacion

import java.math.BigDecimal; // Importa BigDecimal para manejar valores decimales con precisión
import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class Geolocalizacion { // Declara la clase Geolocalizacion, que representa la tabla geolocalizacion

    private int idGeolocalizacion; // Guarda el identificador único de la geolocalización
    private int idUsuario; // Guarda el id del usuario relacionado con la ubicación
    private BigDecimal latitud; // Guarda la latitud con precisión decimal
    private BigDecimal longitud; // Guarda la longitud con precisión decimal
    private Timestamp fechaRegistro; // Guarda la fecha y hora en que se registró la ubicación

    public Geolocalizacion() { // Constructor vacío para crear un objeto sin datos iniciales
    } // Fin del constructor vacío

    public Geolocalizacion(int idGeolocalizacion, int idUsuario, BigDecimal latitud,
                           BigDecimal longitud, Timestamp fechaRegistro) { // Constructor con todos los datos
        this.idGeolocalizacion = idGeolocalizacion; // Asigna el id recibido al atributo idGeolocalizacion
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.latitud = latitud; // Asigna la latitud recibida al atributo latitud
        this.longitud = longitud; // Asigna la longitud recibida al atributo longitud
        this.fechaRegistro = fechaRegistro; // Asigna la fecha de registro recibida al atributo fechaRegistro
    } // Fin del constructor con parámetros

    public int getIdGeolocalizacion() { // Método para obtener el id de la geolocalización
        return idGeolocalizacion; // Retorna el valor de idGeolocalizacion
    } // Fin del método getIdGeolocalizacion

    public void setIdGeolocalizacion(int idGeolocalizacion) { // Método para cambiar el id de la geolocalización
        this.idGeolocalizacion = idGeolocalizacion; // Asigna el nuevo valor al atributo idGeolocalizacion
    } // Fin del método setIdGeolocalizacion

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public BigDecimal getLatitud() { // Método para obtener la latitud
        return latitud; // Retorna el valor de latitud
    } // Fin del método getLatitud

    public void setLatitud(BigDecimal latitud) { // Método para cambiar la latitud
        this.latitud = latitud; // Asigna el nuevo valor al atributo latitud
    } // Fin del método setLatitud

    public BigDecimal getLongitud() { // Método para obtener la longitud
        return longitud; // Retorna el valor de longitud
    } // Fin del método getLongitud

    public void setLongitud(BigDecimal longitud) { // Método para cambiar la longitud
        this.longitud = longitud; // Asigna el nuevo valor al atributo longitud
    } // Fin del método setLongitud

    public Timestamp getFechaRegistro() { // Método para obtener la fecha y hora de registro
        return fechaRegistro; // Retorna el valor de fechaRegistro
    } // Fin del método getFechaRegistro

    public void setFechaRegistro(Timestamp fechaRegistro) { // Método para cambiar la fecha y hora de registro
        this.fechaRegistro = fechaRegistro; // Asigna el nuevo valor al atributo fechaRegistro
    } // Fin del método setFechaRegistro

} // Fin de la clase Geolocalizacion
