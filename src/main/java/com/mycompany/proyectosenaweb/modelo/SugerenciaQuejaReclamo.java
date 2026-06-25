package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase SugerenciaQuejaReclamo

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class SugerenciaQuejaReclamo { // Declara la clase SugerenciaQuejaReclamo, que representa la tabla sugerencias_quejas_reclamos

    private int idSqr; // Guarda el identificador único de la sugerencia, queja o reclamo
    private int idUsuario; // Guarda el id del usuario que envía la solicitud
    private Integer idServicio; // Guarda el id del servicio relacionado; puede ser null si no aplica
    private String tipo; // Guarda el tipo de solicitud: Sugerencia, Queja o Reclamo
    private String descripcion; // Guarda la descripción escrita por el usuario
    private Timestamp fechaEnvio; // Guarda la fecha y hora en que se envió la solicitud
    private String estado; // Guarda el estado: Pendiente, En Proceso, Resuelto o Cerrado
    private String respuesta; // Guarda la respuesta dada a la solicitud
    private Timestamp fechaRespuesta; // Guarda la fecha y hora en que se respondió la solicitud

    public SugerenciaQuejaReclamo() { // Constructor vacío para crear un objeto sin datos iniciales
    } // Fin del constructor vacío

    public SugerenciaQuejaReclamo(int idSqr, int idUsuario, Integer idServicio,
                                  String tipo, String descripcion, Timestamp fechaEnvio,
                                  String estado, String respuesta,
                                  Timestamp fechaRespuesta) { // Constructor con todos los datos
        this.idSqr = idSqr; // Asigna el id recibido al atributo idSqr
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.idServicio = idServicio; // Asigna el id del servicio recibido al atributo idServicio
        this.tipo = tipo; // Asigna el tipo recibido al atributo tipo
        this.descripcion = descripcion; // Asigna la descripción recibida al atributo descripcion
        this.fechaEnvio = fechaEnvio; // Asigna la fecha de envío recibida al atributo fechaEnvio
        this.estado = estado; // Asigna el estado recibido al atributo estado
        this.respuesta = respuesta; // Asigna la respuesta recibida al atributo respuesta
        this.fechaRespuesta = fechaRespuesta; // Asigna la fecha de respuesta recibida al atributo fechaRespuesta
    } // Fin del constructor con parámetros

    public int getIdSqr() { // Método para obtener el id de la solicitud
        return idSqr; // Retorna el valor de idSqr
    } // Fin del método getIdSqr

    public void setIdSqr(int idSqr) { // Método para cambiar el id de la solicitud
        this.idSqr = idSqr; // Asigna el nuevo valor al atributo idSqr
    } // Fin del método setIdSqr

    public int getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public Integer getIdServicio() { // Método para obtener el id del servicio
        return idServicio; // Retorna el valor de idServicio
    } // Fin del método getIdServicio

    public void setIdServicio(Integer idServicio) { // Método para cambiar el id del servicio
        this.idServicio = idServicio; // Asigna el nuevo valor al atributo idServicio
    } // Fin del método setIdServicio

    public String getTipo() { // Método para obtener el tipo de solicitud
        return tipo; // Retorna el valor de tipo
    } // Fin del método getTipo
    
    public void setTipo(String tipo) { // Método para cambiar el tipo de solicitud
        this.tipo = tipo; // Asigna el nuevo valor al atributo tipo
    } // Fin del método setTipo

    public String getDescripcion() { // Método para obtener la descripción
        return descripcion; // Retorna el valor de descripcion
    } // Fin del método getDescripcion

    public void setDescripcion(String descripcion) { // Método para cambiar la descripción
        this.descripcion = descripcion; // Asigna el nuevo valor al atributo descripcion
    } // Fin del método setDescripcion

    public Timestamp getFechaEnvio() { // Método para obtener la fecha y hora de envío
        return fechaEnvio; // Retorna el valor de fechaEnvio
    } // Fin del método getFechaEnvio

    public void setFechaEnvio(Timestamp fechaEnvio) { // Método para cambiar la fecha y hora de envío
        this.fechaEnvio = fechaEnvio; // Asigna el nuevo valor al atributo fechaEnvio
    } // Fin del método setFechaEnvio

    public String getEstado() { // Método para obtener el estado de la solicitud
        return estado; // Retorna el valor de estado
    } // Fin del método getEstado

    public void setEstado(String estado) { // Método para cambiar el estado de la solicitud
        this.estado = estado; // Asigna el nuevo valor al atributo estado
    } // Fin del método setEstado

    public String getRespuesta() { // Método para obtener la respuesta
        return respuesta; // Retorna el valor de respuesta
    } // Fin del método getRespuesta

    public void setRespuesta(String respuesta) { // Método para cambiar la respuesta
        this.respuesta = respuesta; // Asigna el nuevo valor al atributo respuesta
    } // Fin del método setRespuesta

    public Timestamp getFechaRespuesta() { // Método para obtener la fecha y hora de respuesta
        return fechaRespuesta; // Retorna el valor de fechaRespuesta
    } // Fin del método getFechaRespuesta

    public void setFechaRespuesta(Timestamp fechaRespuesta) { // Método para cambiar la fecha y hora de respuesta
        this.fechaRespuesta = fechaRespuesta; // Asigna el nuevo valor al atributo fechaRespuesta
    } // Fin del método setFechaRespuesta

} // Fin de la clase SugerenciaQuejaReclamo