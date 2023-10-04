package es.albarregas.SMVictor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victo
 */
@WebServlet(name = "FormularioComplejo", urlPatterns = {"/FormularioComplejo"})
public class FormularioComplejo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/estilo.css\" />");
            out.println("<title>Servlet Formulario Complejo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formulario Complejo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/estilo.css\" />");
            out.println("<style>");
            out.println(".container {");
            out.println("    width: 80%;"); // Ancho del contenedor
            out.println("    margin: 0 auto;"); // Centrar horizontalmente
            out.println("    padding: 20px;");
            out.println("    border: 1px solid #00f;"); // Borde fino azul
            out.println("    text-align: center;"); // Centrar el texto
            out.println("}");
            out.println("</style>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Formulario Complejo</title>");
            out.println("</head>");
            out.println("<body>");

            // Contenedor principal
            out.println("<div class=\"container\">");

            // Obteniendo los valores enviados desde el formulario
            String usuario = request.getParameter("uname");
            String contrasena = request.getParameter("pname");
            String edad = request.getParameter("edades");
            String[] aficiones = request.getParameterValues("aficiones");
            String estadoCivil = request.getParameter("estadoCivil");
            String comentarios = request.getParameter("message");
            String internet = request.getParameter("internet");
            String sistemaOperativo = request.getParameter("SO");
            String hiden = request.getParameter("oculto");

            // Imprimiendo los valores en la página
            out.println("<h1>Datos del formulario</h1>");
            out.println("<p>Usuario: " + usuario + "</p>");
            out.println("<p>Contraseña: " + contrasena + "</p>");
            out.println("<p>Edad: " + edad + "</p>");
            out.println("<p>Aficiones seleccionadas: ");
            if (aficiones != null && aficiones.length > 0) {
                out.println("<ul>");
                for (String aficion : aficiones) {
                    out.println("<li>" + aficion + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("No se seleccionaron aficiones.");
            }
            out.println("</p>");

            out.println("<p>Estado Civil: " + estadoCivil + "</p>");
            out.println("<p>Comentarios: " + comentarios + "</p>");
            out.println("<p>¿Dispone de internet?: " + internet + "</p>");
            out.println("<p>Sistema Operativo: " + sistemaOperativo + "</p>");
            out.println("<p>oculto: " + hiden + "</p>");

            // Cierre del contenedor principal
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
