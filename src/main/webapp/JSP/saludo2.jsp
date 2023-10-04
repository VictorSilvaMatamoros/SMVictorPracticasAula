<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<link href="../CSS/jsp/saludos2.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado</title>
</head>
<body>
    <form action="saludo2.jsp" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br><br>
        
        <input type="submit" value="Calcular Tiempo de Vida">
    </form>
    <h1>Resultado</h1>
    <%
        // Verificar si el formulario se ha enviado
        if (request.getMethod().equalsIgnoreCase("POST")) {
            // Obtener los parámetros del formulario
            String nombre = request.getParameter("nombre");
            String fechaNacimientoStr = request.getParameter("fechaNacimiento");
            Date fechaActual = new Date();

            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                try {
                    // Parsear la fecha de nacimiento a un objeto java.util.Date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaNacimiento = sdf.parse(fechaNacimientoStr);

                    // Verificar si la fecha de nacimiento es válida
                    if (fechaNacimiento.before(fechaActual)) {
                        // Calcular la diferencia en milisegundos
                        long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();

                        // Calcular años, meses y días
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(diferencia);

                        int años = calendar.get(Calendar.YEAR) - 1970;
                        int meses = calendar.get(Calendar.MONTH);
                        int dias = calendar.get(Calendar.DAY_OF_MONTH) - 1;
    %>
    <p>Hola, <%= nombre %>! Has estado vivo durante 
        <% if (años > 0) { %>
            <%= años %> <%= (años == 1) ? "año" : "años" %>
        <% } %>
        <% if (meses > 0) { %>
            <%= meses %> <%= (meses == 1) ? "mes" : "meses" %>
        <% } %>
        <% if (dias > 0) { %>
            <%= dias %>  <%= (dias == 1) ? "día" : "días" %>
        <% } %>
    </p>
    <%
                    } else {
    %>
    <p>Error al calcular el tiempo de vida. La fecha de nacimiento debe ser anterior a la fecha actual.</p>
    <%
                    }
                } catch (java.text.ParseException e) {
    %>
    <p>Error al calcular el tiempo de vida. La fecha de nacimiento ingresada no es válida.</p>
    <%
                }
            } else {
    %>
    <p>Error al calcular el tiempo de vida. Debes ingresar una fecha de nacimiento válida.</p>
    <%
            }
        }
    %>
</body>
</html>