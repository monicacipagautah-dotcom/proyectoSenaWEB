package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Pago

import java.math.BigDecimal; // Importa BigDecimal para manejar valores monetarios con precisión
import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora de pago

public class Pago { // Declara la clase Pago, que representa la tabla pagos de la base de datos

    private int idPago; // Almacena el identificador único del pago
    private int idServicio; // Almacena el id del servicio relacionado con el pago
    private Integer idMetodoPago; // Almacena el id del método de pago, puede ser null si no hay método registrado
    private String medioPago; // Almacena el medio de pago: Efectivo, PSE o Tarjeta
    private BigDecimal monto; // Almacena el monto del pago con precisión decimal
    private String estado; // Almacena el estado del pago: Pendiente, Aprobado, Rechazado o Cancelado
    private Timestamp fechaPago; // Almacena la fecha y hora en que se registró el pago

    public Pago() { // Constructor vacío que permite crear un objeto Pago sin datos iniciales
    } // Fin del constructor vacío

    public Pago(int idPago, int idServicio, Integer idMetodoPago, String medioPago,
                BigDecimal monto, String estado, Timestamp fechaPago) { // Constructor que recibe todos los datos del pago
        this.idPago = idPago; // Asigna el valor recibido al atributo idPago
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
        this.idMetodoPago = idMetodoPago; // Asigna el valor recibido al atributo idMetodoPago
        this.medioPago = medioPago; // Asigna el valor recibido al atributo medioPago
        this.monto = monto; // Asigna el valor recibido al atributo monto
        this.estado = estado; // Asigna el valor recibido al atributo estado
        this.fechaPago = fechaPago; // Asigna el valor recibido al atributo fechaPago
    } // Fin del constructor con parámetros

    public int getIdPago() { // Método que permite obtener el id del pago
        return idPago; // Retorna el valor almacenado en idPago
    } // Fin del método getIdPago

    public void setIdPago(int idPago) { // Método que permite modificar el id del pago
        this.idPago = idPago; // Asigna el valor recibido al atributo idPago
    } // Fin del método setIdPago

    public int getIdServicio() { // Método que permite obtener el id del servicio relacionado
        return idServicio; // Retorna el valor almacenado en idServicio
    } // Fin del método getIdServicio

    public void setIdServicio(int idServicio) { // Método que permite modificar el id del servicio relacionado
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
    } // Fin del método setIdServicio

    public Integer getIdMetodoPago() { // Método que permite obtener el id del método de pago
        return idMetodoPago; // Retorna el valor almacenado en idMetodoPago
    } // Fin del método getIdMetodoPago

    public void setIdMetodoPago(Integer idMetodoPago) { // Método que permite modificar el id del método de pago
        this.idMetodoPago = idMetodoPago; // Asigna el valor recibido al atributo idMetodoPago
    } // Fin del método setIdMetodoPago

    public String getMedioPago() { // Método que permite obtener el medio de pago utilizado
        return medioPago; // Retorna el valor almacenado en medioPago
    } // Fin del método getMedioPago

    public void setMedioPago(String medioPago) { // Método que permite modificar el medio de pago utilizado
        this.medioPago = medioPago; // Asigna el valor recibido al atributo medioPago
    } // Fin del método setMedioPago
    
    public BigDecimal getMonto() { // Método que permite obtener el monto del pago
        return monto; // Retorna el valor almacenado en monto
    } // Fin del método getMonto

    public void setMonto(BigDecimal monto) { // Método que permite modificar el monto del pago
        this.monto = monto; // Asigna el valor recibido al atributo monto
    } // Fin del método setMonto

    public String getEstado() { // Método que permite obtener el estado del pago
        return estado; // Retorna el valor almacenado en estado
    } // Fin del método getEstado

    public void setEstado(String estado) { // Método que permite modificar el estado del pago
        this.estado = estado; // Asigna el valor recibido al atributo estado
    } // Fin del método setEstado

    public Timestamp getFechaPago() { // Método que permite obtener la fecha y hora del pago
        return fechaPago; // Retorna el valor almacenado en fechaPago
    } // Fin del método getFechaPago

    public void setFechaPago(Timestamp fechaPago) { // Método que permite modificar la fecha y hora del pago
        this.fechaPago = fechaPago; // Asigna el valor recibido al atributo fechaPago
    } // Fin del método setFechaPago

} // Fin de la clase Pago
