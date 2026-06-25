package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase IntentoLogin

import java.sql.Timestamp; // Importa Timestamp para manejar fecha y hora

public class IntentoLogin { // Declara la clase IntentoLogin, que representa la tabla intentos_login

    private int idIntento; // Guarda el identificador único del intento de login
    private Integer idUsuario; // Guarda el id del usuario; puede ser null si el correo no existe
    private String correoIngresado; // Guarda el correo que la persona escribió al intentar iniciar sesión
    private Timestamp fecha; // Guarda la fecha y hora del intento de login
    private String ip; // Guarda la dirección IP desde donde se hizo el intento
    private String resultado; // Guarda el resultado del intento: Exitoso o Fallido

    public IntentoLogin() { // Constructor vacío para crear un objeto IntentoLogin sin datos iniciales
    } // Fin del constructor vacío

    public IntentoLogin(int idIntento, Integer idUsuario, String correoIngresado,
                        Timestamp fecha, String ip, String resultado) { // Constructor con todos los datos
        this.idIntento = idIntento; // Asigna el id recibido al atributo idIntento
        this.idUsuario = idUsuario; // Asigna el id del usuario recibido al atributo idUsuario
        this.correoIngresado = correoIngresado; // Asigna el correo recibido al atributo correoIngresado
        this.fecha = fecha; // Asigna la fecha recibida al atributo fecha
        this.ip = ip; // Asigna la IP recibida al atributo ip
        this.resultado = resultado; // Asigna el resultado recibido al atributo resultado
    } // Fin del constructor con parámetros

    public int getIdIntento() { // Método para obtener el id del intento
        return idIntento; // Retorna el valor de idIntento
    } // Fin del método getIdIntento

    public void setIdIntento(int idIntento) { // Método para cambiar el id del intento
        this.idIntento = idIntento; // Asigna el nuevo valor al atributo idIntento
    } // Fin del método setIdIntento

    public Integer getIdUsuario() { // Método para obtener el id del usuario
        return idUsuario; // Retorna el valor de idUsuario
    } // Fin del método getIdUsuario

    public void setIdUsuario(Integer idUsuario) { // Método para cambiar el id del usuario
        this.idUsuario = idUsuario; // Asigna el nuevo valor al atributo idUsuario
    } // Fin del método setIdUsuario

    public String getCorreoIngresado() { // Método para obtener el correo ingresado
        return correoIngresado; // Retorna el valor de correoIngresado
    } // Fin del método getCorreoIngresado

    public void setCorreoIngresado(String correoIngresado) { // Método para cambiar el correo ingresado
        this.correoIngresado = correoIngresado; // Asigna el nuevo valor al atributo correoIngresado
    } // Fin del método setCorreoIngresado

    public Timestamp getFecha() { // Método para obtener la fecha y hora del intento
        return fecha; // Retorna el valor de fecha
    } // Fin del método getFecha

    public void setFecha(Timestamp fecha) { // Método para cambiar la fecha y hora del intento
        this.fecha = fecha; // Asigna el nuevo valor al atributo fecha
    } // Fin del método setFecha

    public String getIp() { // Método para obtener la IP del intento
        return ip; // Retorna el valor de ip
    } // Fin del método getIp

    public void setIp(String ip) { // Método para cambiar la IP del intento
        this.ip = ip; // Asigna el nuevo valor al atributo ip
    } // Fin del método setIp

    public String getResultado() { // Método para obtener el resultado del intento
        return resultado; // Retorna el valor de resultado
    } // Fin del método getResultado

    public void setResultado(String resultado) { // Método para cambiar el resultado del intento
        this.resultado = resultado; // Asigna el nuevo valor al atributo resultado
    } // Fin del método setResultado

} // Fin de la clase IntentoLogin