
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.prueba2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "Bienvenida", urlPatterns = {"/Bienvenida"})
public class Bienvenida extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Bienvenida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Bienvenida at " + request.getContextPath() + "</h1>");
            out.println("<h2>El método de llamada es " + request.getMethod() + "</h2>");
            
            Enumeration <String> campos=request.getParameterNames();
            String nombre=null;
            while(campos.hasMoreElements()){
                nombre=campos.nextElement();
                out.println("<h2>El campo " + nombre +" es " + request.getParameter(request.getParameterNames().nextElement())+ "</h2>");
            }
            
            out.println("<h2>El parámetro 1 es " + request.getParameter(request.getParameterNames().nextElement())+ "</h2>");
            out.println("<p><a href='./'>Volver al índice " + "</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
     //   processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Bienvenida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Bienvenida at " + request.getContextPath() + "</h1>");
            out.println("<h2>El método de llamada es " + request.getMethod() + "</h2>");
            
             Enumeration <String> campos=request.getParameterNames();
            String nombre=null;
            while(campos.hasMoreElements()){
                nombre=campos.nextElement();
                if(nombre.startsWith("btm")){
                    out.println("<h2>El campo " + nombre +" es " + request.getParameter(nombre)+ "</h2>");
                }    
            }
            
            out.println("<p><a href='./'>Volver al índice " + "</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
       // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}