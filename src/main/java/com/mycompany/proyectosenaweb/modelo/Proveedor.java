package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Proveedor

public class Proveedor { // Declara la clase Proveedor, que representa la tabla proveedores de la base de datos

    private int idProveedor; // Almacena el identificador único del proveedor
    private int idUsuario; // Almacena el id del usuario relacionado con este proveedor
    private String fotoPersonal; // Almacena la ruta o nombre del archivo de la foto personal del proveedor
    private String estadoValidacion; // Almacena el estado de validación: Pendiente, Aprobado o Rechazado

    public Proveedor() { // Constructor vacío que permite crear un objeto Proveedor sin datos iniciales
    } // Fin del constructor vacío

    public Proveedor(int idProveedor, int idUsuario, String fotoPersonal, String estadoValidacion) { // Constructor que recibe todos los datos del proveedor
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
        this.idUsuario = idUsuario; // Asigna el valor recibido al atributo idUsuario
        this.fotoPersonal = fotoPersonal; // Asigna el valor recibido al atributo fotoPersonal
        this.estadoValidacion = estadoValidacion; // Asigna el valor recibido al atributo estadoValidacion
    } // Fin del constructor con parámetros

    public int getIdProveedor() { // Método que permite obtener el id del proveedor
        return idProveedor; // Retorna el valor almacenado en idProveedor
    } // Fin del método getIdProveedor

    public void setIdProveedor(int idProveedor) { // Método que permite modificar el id del proveedor
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
    } // Fin del método setIdProveedor

    public int getIdUsuario() { // Método que permite obtener el id del usuario relacionado
        return idUsuario; // Retorna el valor almacenado en idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método que permite modificar el id del usuario relacionado
        this.idUsuario = idUsuario; // Asigna el valor recibido al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getFotoPersonal() { // Método que permite obtener la foto personal del proveedor
        return fotoPersonal; // Retorna el valor almacenado en fotoPersonal
    } // Fin del método getFotoPersonal

    public void setFotoPersonal(String fotoPersonal) { // Método que permite modificar la foto personal del proveedor
        this.fotoPersonal = fotoPersonal; // Asigna el valor recibido al atributo fotoPersonal
    } // Fin del método setFotoPersonal

    public String getEstadoValidacion() { // Método que permite obtener el estado de validación del proveedor
        return estadoValidacion; // Retorna el valor almacenado en estadoValidacion
    } // Fin del método getEstadoValidacion

    public void setEstadoValidacion(String estadoValidacion) { // Método que permite modificar el estado de validación del proveedor
        this.estadoValidacion = estadoValidacion; // Asigna el valor recibido al atributo estadoValidacion
    } // Fin del método setEstadoValidacion

} // Fin de la clase Proveedor