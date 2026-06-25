package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Servicio

import java.sql.Date; // Importa Date para manejar fechas SQL
import java.sql.Time; // Importa Time para manejar horas SQL

public class Servicio { // Declara la clase Servicio, que representa la tabla servicios de la base de datos

    private int idServicio; // Almacena el identificador único del servicio
    private int idCliente; // Almacena el id del cliente que solicita el servicio
    private Integer idProveedor; // Almacena el id del proveedor asignado al servicio
    private String tipo; // Almacena el tipo de servicio solicitado
    private Date fecha; // Almacena la fecha programada del servicio
    private Time hora; // Almacena la hora programada del servicio
    private String direccion; // Almacena la dirección donde se realizará el servicio
    private String estado; // Almacena el estado del servicio: Pendiente, Confirmado, Cancelado o Finalizado

    public Servicio() { // Constructor vacío que permite crear un objeto Servicio sin datos iniciales
    } // Fin del constructor vacío

    public Servicio(int idServicio, int idCliente, Integer idProveedor, String tipo,
                    Date fecha, Time hora, String direccion, String estado) { // Constructor que recibe todos los datos del servicio
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
        this.tipo = tipo; // Asigna el valor recibido al atributo tipo
        this.fecha = fecha; // Asigna el valor recibido al atributo fecha
        this.hora = hora; // Asigna el valor recibido al atributo hora
        this.direccion = direccion; // Asigna el valor recibido al atributo direccion
        this.estado = estado; // Asigna el valor recibido al atributo estado
    } // Fin del constructor con parámetros

    public int getIdServicio() { // Método que permite obtener el id del servicio
        return idServicio; // Retorna el valor almacenado en idServicio
    } // Fin del método getIdServicio

    public void setIdServicio(int idServicio) { // Método que permite modificar el id del servicio
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
    } // Fin del método setIdServicio

    public int getIdCliente() { // Método que permite obtener el id del cliente
        return idCliente; // Retorna el valor almacenado en idCliente
    } // Fin del método getIdCliente

    public void setIdCliente(int idCliente) { // Método que permite modificar el id del cliente
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
    } // Fin del método setIdCliente

    public Integer getIdProveedor() { // Método que permite obtener el id del proveedor
        return idProveedor; // Retorna el valor almacenado en idProveedor
    } // Fin del método getIdProveedor

    public void setIdProveedor(Integer idProveedor) { // Método que permite modificar el id del proveedor
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
    } // Fin del método setIdProveedor

    public String getTipo() { // Método que permite obtener el tipo de servicio
        return tipo; // Retorna el valor almacenado en tipo
    } // Fin del método getTipo

    public void setTipo(String tipo) { // Método que permite modificar el tipo de servicio
        this.tipo = tipo; // Asigna el valor recibido al atributo tipo
    } // Fin del método setTipo

    public Date getFecha() { // Método que permite obtener la fecha del servicio
        return fecha; // Retorna el valor almacenado en fecha
    } // Fin del método getFecha
    
public void setFecha(Date fecha) { // Método que permite modificar la fecha del servicio
        this.fecha = fecha; // Asigna el valor recibido al atributo fecha
    } // Fin del método setFecha

    public Time getHora() { // Método que permite obtener la hora del servicio
        return hora; // Retorna el valor almacenado en hora
    } // Fin del método getHora

    public void setHora(Time hora) { // Método que permite modificar la hora del servicio
        this.hora = hora; // Asigna el valor recibido al atributo hora
    } // Fin del método setHora

    public String getDireccion() { // Método que permite obtener la dirección del servicio
        return direccion; // Retorna el valor almacenado en direccion
    } // Fin del método getDireccion

    public void setDireccion(String direccion) { // Método que permite modificar la dirección del servicio
        this.direccion = direccion; // Asigna el valor recibido al atributo direccion
    } // Fin del método setDireccion

    public String getEstado() { // Método que permite obtener el estado del servicio
        return estado; // Retorna el valor almacenado en estado
    } // Fin del método getEstado

    public void setEstado(String estado) { // Método que permite modificar el estado del servicio
        this.estado = estado; // Asigna el valor recibido al atributo estado
    } // Fin del método setEstado

} // Fin de la clase Servicio
