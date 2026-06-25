package com.mycompany.proyectosenaweb.servlet; // Paquete del servlet

import com.mycompany.proyectosenaweb.dao.UsuarioDAO; // Importa UsuarioDAO
import com.mycompany.proyectosenaweb.modelo.Usuario; // Importa modelo Usuario
import jakarta.servlet.ServletException; // Maneja errores de servlet
import jakarta.servlet.annotation.WebServlet; // Permite usar anotación de ruta
import jakarta.servlet.http.HttpServlet; // Clase base de servlet
import jakarta.servlet.http.HttpServletRequest; // Recibe datos del navegador
import jakarta.servlet.http.HttpServletResponse; // Envía respuestas al navegador
import jakarta.servlet.http.HttpSession; // Maneja sesiones de usuario
import java.io.IOException; // Maneja errores de entrada y salida

@WebServlet("/LoginServlet") // Ruta para llamar este servlet
public class LoginServlet extends HttpServlet { // Clase servlet para login

    private final UsuarioDAO dao = new UsuarioDAO(); // Objeto DAO para consultar usuarios

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Atiende formularios POST

        request.setCharacterEncoding("UTF-8"); // Permite tildes y caracteres especiales

        String correo = request.getParameter("correo"); // Obtiene el correo del formulario
        String passwordHash = request.getParameter("passwordHash"); // Obtiene la contraseña del formulario

        Usuario usuario = dao.validarLogin(correo, passwordHash); // Valida usuario en la base de datos

        if (usuario != null) { // Si encontró usuario
            HttpSession session = request.getSession(); // Crea o recupera la sesión
            session.setAttribute("usuarioLogueado", usuario); // Guarda el usuario en sesión
            response.sendRedirect("menu.jsp"); // Redirige al menú
        } else { // Si no encontró usuario
            response.sendRedirect("login.jsp"); // Vuelve al login
        }
    }
}