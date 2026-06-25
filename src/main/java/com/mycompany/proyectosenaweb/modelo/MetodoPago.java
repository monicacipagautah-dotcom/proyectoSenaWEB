package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase MetodoPago

public class MetodoPago { // Declara la clase MetodoPago, que representa la tabla metodos_pago de la base de datos

    private int idMetodoPago; // Almacena el identificador único del método de pago
    private int idCliente; // Almacena el id del cliente dueño del método de pago
    private String medioPago; // Almacena el medio de pago: Efectivo, PSE o Tarjeta
    private String estado; // Almacena el estado del método de pago: Activo o Inactivo
    private String descripcion; // Almacena una descripción del método de pago

    public MetodoPago() { // Constructor vacío que permite crear un objeto MetodoPago sin datos iniciales
    } // Fin del constructor vacío

    public MetodoPago(int idMetodoPago, int idCliente, String medioPago,
                      String estado, String descripcion) { // Constructor que recibe todos los datos del método de pago
        this.idMetodoPago = idMetodoPago; // Asigna el valor recibido al atributo idMetodoPago
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
        this.medioPago = medioPago; // Asigna el valor recibido al atributo medioPago
        this.estado = estado; // Asigna el valor recibido al atributo estado
        this.descripcion = descripcion; // Asigna el valor recibido al atributo descripcion
    } // Fin del constructor con parámetros

    public int getIdMetodoPago() { // Método que permite obtener el id del método de pago
        return idMetodoPago; // Retorna el valor almacenado en idMetodoPago
    } // Fin del método getIdMetodoPago

    public void setIdMetodoPago(int idMetodoPago) { // Método que permite modificar el id del método de pago
        this.idMetodoPago = idMetodoPago; // Asigna el valor recibido al atributo idMetodoPago
    } // Fin del método setIdMetodoPago

    public int getIdCliente() { // Método que permite obtener el id del cliente
        return idCliente; // Retorna el valor almacenado en idCliente
    } // Fin del método getIdCliente

    public void setIdCliente(int idCliente) { // Método que permite modificar el id del cliente
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
    } // Fin del método setIdCliente

    public String getMedioPago() { // Método que permite obtener el medio de pago
        return medioPago; // Retorna el valor almacenado en medioPago
    } // Fin del método getMedioPago

    public void setMedioPago(String medioPago) { // Método que permite modificar el medio de pago
        this.medioPago = medioPago; // Asigna el valor recibido al atributo medioPago
    } // Fin del método setMedioPago

    public String getEstado() { // Método que permite obtener el estado del método de pago
        return estado; // Retorna el valor almacenado en estado
    } // Fin del método getEstado

    public void setEstado(String estado) { // Método que permite modificar el estado del método de pago
        this.estado = estado; // Asigna el valor recibido al atributo estado
    } // Fin del método setEstado

    public String getDescripcion() { // Método que permite obtener la descripción del método de pago
        return descripcion; // Retorna el valor almacenado en descripcion
    } // Fin del método getDescripcion

    public void setDescripcion(String descripcion) { // Método que permite modificar la descripción del método de pago
        this.descripcion = descripcion; // Asigna el valor recibido al atributo descripcion
    } // Fin del método setDescripcion

} // Fin de la clase MetodoPago