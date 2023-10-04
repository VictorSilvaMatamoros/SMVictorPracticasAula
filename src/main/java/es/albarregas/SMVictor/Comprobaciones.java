package es.albarregas.SMVictor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Comprobaciones", urlPatterns = {"/Comprobaciones"})
public class Comprobaciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/comprobaciones.css\" />");
            out.println("<title>Servlet Comprobaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comprobaciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Procesa los datos del formulario enviado por POST
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String preferencias = request.getParameter("preferencias");

        // Realiza cualquier lógica de procesamiento necesaria aquí

        // Envía una respuesta al usuario
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/comprobaciones.css\" />");
            out.println("<title>Servlet Comprobaciones - Resultado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado del Formulario</h1>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Apellido: " + apellido + "</p>");
            out.println("<p>Sexo: " + sexo + "</p>");
            out.println("<p>Fecha de Nacimiento: " + fechaNacimiento + "</p>");
            out.println("<p>Usuario: " + usuario + "</p>");
            out.println("<p>Contraseña: " + password + "</p>");
            out.println("<p>Preferencias: " + preferencias + "</p>");
            out.println("<a href=\"formulario.html\">Volver al formulario</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Comprobaciones Servlet";
    }
}
