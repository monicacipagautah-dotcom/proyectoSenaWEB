package com.mycompany.proyectosenaweb.modelo; // Define el paquete donde se encuentra la clase Calificacion

public class Calificacion { // Declara la clase Calificacion, que representa la tabla calificaciones de la base de datos

    private int idCalificacion; // Almacena el identificador único de la calificación
    private int idCliente; // Almacena el id del cliente que realiza la calificación
    private int idProveedor; // Almacena el id del proveedor calificado
    private int idServicio; // Almacena el id del servicio relacionado con la calificación
    private int puntuacion; // Almacena la puntuación dada, entre 1 y 5
    private String comentario; // Almacena el comentario escrito por el cliente
    private boolean anonimato; // Indica si la calificación se hizo de forma anónima
    private boolean reportado; // Indica si la calificación fue reportada
    private String motivoReporte; // Almacena el motivo del reporte si la calificación fue reportada

    public Calificacion() { // Constructor vacío que permite crear un objeto Calificacion sin datos iniciales
    } // Fin del constructor vacío

    public Calificacion(int idCalificacion, int idCliente, int idProveedor, int idServicio,
                        int puntuacion, String comentario, boolean anonimato,
                        boolean reportado, String motivoReporte) { // Constructor que recibe todos los datos de la calificación
        this.idCalificacion = idCalificacion; // Asigna el valor recibido al atributo idCalificacion
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
        this.puntuacion = puntuacion; // Asigna el valor recibido al atributo puntuacion
        this.comentario = comentario; // Asigna el valor recibido al atributo comentario
        this.anonimato = anonimato; // Asigna el valor recibido al atributo anonimato
        this.reportado = reportado; // Asigna el valor recibido al atributo reportado
        this.motivoReporte = motivoReporte; // Asigna el valor recibido al atributo motivoReporte
    } // Fin del constructor con parámetros

    public int getIdCalificacion() { // Método que permite obtener el id de la calificación
        return idCalificacion; // Retorna el valor almacenado en idCalificacion
    } // Fin del método getIdCalificacion

    public void setIdCalificacion(int idCalificacion) { // Método que permite modificar el id de la calificación
        this.idCalificacion = idCalificacion; // Asigna el valor recibido al atributo idCalificacion
    } // Fin del método setIdCalificacion

    public int getIdCliente() { // Método que permite obtener el id del cliente
        return idCliente; // Retorna el valor almacenado en idCliente
    } // Fin del método getIdCliente

    public void setIdCliente(int idCliente) { // Método que permite modificar el id del cliente
        this.idCliente = idCliente; // Asigna el valor recibido al atributo idCliente
    } // Fin del método setIdCliente

    public int getIdProveedor() { // Método que permite obtener el id del proveedor
        return idProveedor; // Retorna el valor almacenado en idProveedor
    } // Fin del método getIdProveedor

    public void setIdProveedor(int idProveedor) { // Método que permite modificar el id del proveedor
        this.idProveedor = idProveedor; // Asigna el valor recibido al atributo idProveedor
    } // Fin del método setIdProveedor

    public int getIdServicio() { // Método que permite obtener el id del servicio
        return idServicio; // Retorna el valor almacenado en idServicio
    } // Fin del método getIdServicio
    
public void setIdServicio(int idServicio) { // Método que permite modificar el id del servicio
        this.idServicio = idServicio; // Asigna el valor recibido al atributo idServicio
    } // Fin del método setIdServicio

    public int getPuntuacion() { // Método que permite obtener la puntuación de la calificación
        return puntuacion; // Retorna el valor almacenado en puntuacion
    } // Fin del método getPuntuacion

    public void setPuntuacion(int puntuacion) { // Método que permite modificar la puntuación de la calificación
        this.puntuacion = puntuacion; // Asigna el valor recibido al atributo puntuacion
    } // Fin del método setPuntuacion

    public String getComentario() { // Método que permite obtener el comentario de la calificación
        return comentario; // Retorna el valor almacenado en comentario
    } // Fin del método getComentario

    public void setComentario(String comentario) { // Método que permite modificar el comentario de la calificación
        this.comentario = comentario; // Asigna el valor recibido al atributo comentario
    } // Fin del método setComentario

    public boolean isAnonimato() { // Método que permite saber si la calificación es anónima
        return anonimato; // Retorna true si es anónima o false si no lo es
    } // Fin del método isAnonimato

    public void setAnonimato(boolean anonimato) { // Método que permite modificar si la calificación es anónima
        this.anonimato = anonimato; // Asigna el valor recibido al atributo anonimato
    } // Fin del método setAnonimato

    public boolean isReportado() { // Método que permite saber si la calificación fue reportada
        return reportado; // Retorna true si fue reportada o false si no lo fue
    } // Fin del método isReportado

    public void setReportado(boolean reportado) { // Método que permite modificar si la calificación fue reportada
        this.reportado = reportado; // Asigna el valor recibido al atributo reportado
    } // Fin del método setReportado

    public String getMotivoReporte() { // Método que permite obtener el motivo del reporte
        return motivoReporte; // Retorna el valor almacenado en motivoReporte
    } // Fin del método getMotivoReporte

    public void setMotivoReporte(String motivoReporte) { // Método que permite modificar el motivo del reporte
        this.motivoReporte = motivoReporte; // Asigna el valor recibido al atributo motivoReporte
    } // Fin del método setMotivoReporte

} // Fin de la clase Calificacion