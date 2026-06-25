package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Usuario dentro del proyecto

import java.sql.Date; // Importa la clase Date para manejar fechas compatibles con bases de datos SQL

public class Usuario { // Declara la clase Usuario, que representa la tabla usuarios de la base de datos

    private int idUsuario; // Almacena el identificador único del usuario en la base de datos
    private String nombre; // Almacena el nombre completo del usuario
    private String fotoPerfil; // Almacena la ruta o nombre del archivo de la foto de perfil
    private String correo; // Almacena el correo electrónico del usuario
    private String telefono; // Almacena el número de teléfono del usuario
    private String passwordHash; // Almacena la contraseña cifrada o encriptada del usuario
    private String fotoCedula; // Almacena la ruta o nombre del archivo de la foto de la cédula
    private Date fechaNacimiento; // Almacena la fecha de nacimiento del usuario
    private String estado; // Almacena el estado del usuario: Activo, Pendiente, Rechazado o Eliminado
    private String rol; // Almacena el rol del usuario: Cliente o Prestador

    public Usuario() { // Constructor vacío que permite crear un objeto Usuario sin asignar valores iniciales
    } // Fin del constructor vacío

    public Usuario(int idUsuario, String nombre, String fotoPerfil, String correo,
                   String telefono, String passwordHash, String fotoCedula,
                   Date fechaNacimiento, String estado, String rol) { // Constructor que recibe todos los datos del usuario
        this.idUsuario = idUsuario; // Asigna el valor recibido al atributo idUsuario
        this.nombre = nombre; // Asigna el valor recibido al atributo nombre
        this.fotoPerfil = fotoPerfil; // Asigna el valor recibido al atributo fotoPerfil
        this.correo = correo; // Asigna el valor recibido al atributo correo
        this.telefono = telefono; // Asigna el valor recibido al atributo telefono
        this.passwordHash = passwordHash; // Asigna el valor recibido al atributo passwordHash
        this.fotoCedula = fotoCedula; // Asigna el valor recibido al atributo fotoCedula
        this.fechaNacimiento = fechaNacimiento; // Asigna el valor recibido al atributo fechaNacimiento
        this.estado = estado; // Asigna el valor recibido al atributo estado
        this.rol = rol; // Asigna el valor recibido al atributo rol
    } // Fin del constructor con parámetros

    public int getIdUsuario() { // Método que permite obtener el id del usuario
        return idUsuario; // Retorna el valor almacenado en idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(int idUsuario) { // Método que permite modificar el rol del usuario
        this.idUsuario = idUsuario; //Asigna el valor recibido al atributo rol
    } //Fin del método setIdUsuario
    
    public String getNombre(){ //Método que permite obtener el nombre del usuario
        return nombre; //Retorna el valor almacenado en nombre 
    } //Fin método getNombre
    
    public void setNombre(String nombre){ //Método que permite modificar el nombre del usuario 
        this.nombre = nombre;
    } //fin del metodo setNombre
    
    public String getFotoPerfil(){  //Metodo que permite obtener la foto del perfil
        return fotoPerfil; //Retornar el valor almacenado en fotoPerfil 
    } //fin del metodo getFotoPerfil
    
    public void setFotoPerfil(String fotoPerfil) {//Metodo que permite modificar la foto del perfil 
        this.fotoPerfil = fotoPerfil;
    } //Fin del método setFotoPerfil
    
    public String getCorreo() { // Método que permite obtener el correo electrónico del usuario
        return correo; // Retorna el valor almacenado en correo
    } // Fin del método getCorreo

    public void setCorreo(String correo) { // Método que permite modificar el correo electrónico del usuario
        this.correo = correo; // Asigna el valor recibido al atributo correo
    } // Fin del método setCorreo

    public String getTelefono() { // Método que permite obtener el teléfono del usuario
        return telefono; // Retorna el valor almacenado en telefono
    } // Fin del método getTelefono

    public void setTelefono(String telefono) { // Método que permite modificar el teléfono del usuario
        this.telefono = telefono; // Asigna el valor recibido al atributo telefono
    } // Fin del método setTelefono

    public String getPasswordHash() { // Método que permite obtener la contraseña cifrada del usuario
        return passwordHash; // Retorna el valor almacenado en passwordHash
    } // Fin del método getPasswordHash
    
    public void setPasswordHash(String passwordHash) { // Método que permite modificar la contraseña cifrada del usuario
        this.passwordHash = passwordHash; // Asigna el valor recibido al atributo passwordHash
    } // Fin del método setPasswordHash

    public String getFotoCedula() { // Método que permite obtener la foto de la cédula del usuario
        return fotoCedula; // Retorna el valor almacenado en fotoCedula
    } // Fin del método getFotoCedula

    public void setFotoCedula(String fotoCedula) { // Método que permite modificar la foto de la cédula del usuario
        this.fotoCedula = fotoCedula; // Asigna el valor recibido al atributo fotoCedula
    } // Fin del método setFotoCedula

    public Date getFechaNacimiento() { // Método que permite obtener la fecha de nacimiento del usuario
        return fechaNacimiento; // Retorna el valor almacenado en fechaNacimiento
    } // Fin del método getFechaNacimiento

    public void setFechaNacimiento(Date fechaNacimiento) { // Método que permite modificar la fecha de nacimiento del usuario
        this.fechaNacimiento = fechaNacimiento; // Asigna el valor recibido al atributo fechaNacimiento
    } // Fin del método setFechaNacimiento
    
    public String getEstado() { // Método que permite obtener el estado actual del usuario
        return estado; // Retorna el valor almacenado en estado
    } // Fin del método getEstado

    public void setEstado(String estado) { // Método que permite modificar el estado del usuario
        this.estado = estado; // Asigna el valor recibido al atributo estado
    } // Fin del método setEstado

    public String getRol() { // Método que permite obtener el rol del usuario
        return rol; // Retorna el valor almacenado en rol
    } // Fin del método getRol

    public void setRol(String rol) { // Método que permite modificar el rol del usuario
        this.rol = rol; // Asigna el valor recibido al atributo rol
    } // Fin del método setRol

} // Fin de la clase Usuario