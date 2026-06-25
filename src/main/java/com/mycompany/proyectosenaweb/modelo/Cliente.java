package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Cliente

public class Cliente { // Declara la clase Cliente, que representa la tabla clientes de la base de datos

    private int idCliente; // Almacena el identificador único del cliente
    private int idUsuario; // Almacena el id del usuario relacionado con este cliente
    private String biografia; // Almacena una descripción o biografía del cliente
    private String intenciones; // Almacena las intenciones o necesidades del cliente
    private int numeroContactos; // Almacena la cantidad de contactos del cliente
    private String direccion; // Almacena la dirección del cliente

    public Cliente() { // Constructor vacío que permite crear un objeto Cliente sin datos iniciales
    } // Fin del constructor vacío

    public Cliente(int idCliente, int idUsuario, String biografia, String intenciones,
                   int numeroContactos, String direccion) { // Constructor que recibe todos los datos del cliente
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
        this.idUsuario = idUsuario; // Asigna el valor recibido al atributo idUsuario
        this.biografia = biografia; // Asigna el valor recibido al atributo biografia
        this.intenciones = intenciones; // Asigna el valor recibido al atributo intenciones
        this.numeroContactos = numeroContactos; // Asigna el valor recibido al atributo numeroContactos
        this.direccion = direccion; // Asigna el valor recibido al atributo direccion
    } // Fin del constructor con parámetros

    public int getIdCliente() { // Método que permite obtener el id del cliente
        return idCliente; // Retorna el valor almacenado en idCliente
    } // Fin del método getIdCliente

    public void setIdCliente(int idCliente) { // Método que permite modificar el id del cliente
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
    } // Fin del método setIdCliente

    public int getIdUsuario() { // Método que permite obtener el id del usuario relacionado
        return idUsuario; // Retorna el valor almacenado en idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método que permite modificar el id del usuario relacionado
        this.idUsuario = idUsuario; // Asigna el valor recibido al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getBiografia() { // Método que permite obtener la biografía del cliente
        return biografia; // Retorna el valor almacenado en biografia
    } // Fin del método getBiografia

    public void setBiografia(String biografia) { // Método que permite modificar la biografía del cliente
        this.biografia = biografia; // Asigna el valor recibido al atributo biografia
    } // Fin del método setBiografia

    public String getIntenciones() { // Método que permite obtener las intenciones del cliente
        return intenciones; // Retorna el valor almacenado en intenciones
    } // Fin del método getIntenciones

    public void setIntenciones(String intenciones) { // Método que permite modificar las intenciones del cliente
        this.intenciones = intenciones; // Asigna el valor recibido al atributo intenciones
    } // Fin del método setIntenciones

    public int getNumeroContactos() { // Método que permite obtener el número de contactos del cliente
        return numeroContactos; // Retorna el valor almacenado en numeroContactos
    } // Fin del método getNumeroContactos

    public void setNumeroContactos(int numeroContactos) { // Método que permite modificar el número de contactos
        this.numeroContactos = numeroContactos; // Asigna el valor recibido al atributo numeroContactos
    } // Fin del método setNumeroContactos
    
     public String getDireccion() { // Método que permite obtener la dirección del cliente
        return direccion; // Retorna el valor almacenado en direccion
    } // Fin del método getDireccion

    public void setDireccion(String direccion) { // Método que permite modificar la dirección del cliente
        this.direccion = direccion; // Asigna el valor recibido al atributo direccion
    } // Fin del método setDireccion

} // Fin de la clase  