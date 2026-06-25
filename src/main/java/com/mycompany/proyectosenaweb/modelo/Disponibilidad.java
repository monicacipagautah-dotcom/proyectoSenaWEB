package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Disponibilidad

import java.sql.Time; // Importa Time para manejar horas compatibles con la base de datos SQL

public class Disponibilidad { // Declara la clase Disponibilidad, que representa la tabla disponibilidad

    private int idDisponibilidad; // Guarda el identificador único de la disponibilidad
    private int idProveedor; // Guarda el id del proveedor relacionado con esta disponibilidad
    private String dia; // Guarda el día disponible: Lunes, Martes, Miércoles, Jueves, Viernes, Sábado o Domingo
    private Time horaInicio; // Guarda la hora de inicio de la disponibilidad
    private Time horaFin; // Guarda la hora de finalización de la disponibilidad
    private String tipo; // Guarda el tipo de disponibilidad: General o Personalizada

    public Disponibilidad() { // Constructor vacío para crear un objeto sin datos iniciales
    } // Fin del constructor vacío

    public Disponibilidad(int idDisponibilidad, int idProveedor, String dia,
                          Time horaInicio, Time horaFin, String tipo) { // Constructor con todos los datos
        this.idDisponibilidad = idDisponibilidad; // Asigna el id recibido al atributo idDisponibilidad
        this.idProveedor = idProveedor; // Asigna el id del proveedor recibido al atributo idProveedor
        this.dia = dia; // Asigna el día recibido al atributo dia
        this.horaInicio = horaInicio; // Asigna la hora de inicio recibida al atributo horaInicio
        this.horaFin = horaFin; // Asigna la hora de fin recibida al atributo horaFin
        this.tipo = tipo; // Asigna el tipo recibido al atributo tipo
    } // Fin del constructor con parámetros

    public int getIdDisponibilidad() { // Método para obtener el id de la disponibilidad
        return idDisponibilidad; // Retorna el valor de idDisponibilidad
    } // Fin del método getIdDisponibilidad

    public void setIdDisponibilidad(int idDisponibilidad) { // Método para cambiar el id de la disponibilidad
        this.idDisponibilidad = idDisponibilidad; // Asigna el nuevo valor al atributo idDisponibilidad
    } // Fin del método setIdDisponibilidad

    public int getIdProveedor() { // Método para obtener el id del proveedor
        return idProveedor; // Retorna el valor de idProveedor
    } // Fin del método getIdProveedor

    public void setIdProveedor(int idProveedor) { // Método para cambiar el id del proveedor
        this.idProveedor = idProveedor; // Asigna el nuevo valor al atributo idProveedor
    } // Fin del método setIdProveedor

    public String getDia() { // Método para obtener el día de disponibilidad
        return dia; // Retorna el valor de dia
    } // Fin del método getDia

    public void setDia(String dia) { // Método para cambiar el día de disponibilidad
        this.dia = dia; // Asigna el nuevo valor al atributo dia
    } // Fin del método setDia

    public Time getHoraInicio() { // Método para obtener la hora de inicio
        return horaInicio; // Retorna el valor de horaInicio
    } // Fin del método getHoraInicio

    public void setHoraInicio(Time horaInicio) { // Método para cambiar la hora de inicio
        this.horaInicio = horaInicio; // Asigna el nuevo valor al atributo horaInicio
    } // Fin del método setHoraInicio

    public Time getHoraFin() { // Método para obtener la hora de fin
        return horaFin; // Retorna el valor de horaFin
    } // Fin del método getHoraFin

    public void setHoraFin(Time horaFin) { // Método para cambiar la hora de fin
        this.horaFin = horaFin; // Asigna el nuevo valor al atributo horaFin
    } // Fin del método setHoraFin

    public String getTipo() { // Método para obtener el tipo de disponibilidad
        return tipo; // Retorna el valor de tipo
    } // Fin del método getTipo

    public void setTipo(String tipo) { // Método para cambiar el tipo de disponibilidad
        this.tipo = tipo; // Asigna el nuevo valor al atributo tipo
    } // Fin del método setTipo

} // Fin de la clase Disponibilidad