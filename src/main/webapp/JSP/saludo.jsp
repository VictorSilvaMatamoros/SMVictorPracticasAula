

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="../CSS/jsp/saludos.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saludo</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <form action="saludo.jsp" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <label for="sexo">Sexo:</label>
        <select id="sexo" name="sexo" required>
            <option value="hombre">Hombre</option>
            <option value="mujer">Mujer</option>
        </select>
        
        <input type="submit" value="Enviar">
    </form>
    
    <%
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        
        if (nombre != null && !nombre.isEmpty() && sexo != null && !sexo.isEmpty()) {
            java.util.Date fecha = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH");
            int hora = Integer.parseInt(sdf.format(fecha));
            String saludo = "";
            
            if (hora >= 6 && hora < 12) {
                if (sexo.equals("hombre")) {
                    saludo = "Buenos días señor " + nombre + "!";
                } else if (sexo.equals("mujer")) {
                    saludo = "Buenos días señora " + nombre + "!";
                }
            } else if (hora >= 12 && hora < 18) {
                if (sexo.equals("hombre")) {
                    saludo = "Buenas tardes señor " + nombre + "!";
                } else if (sexo.equals("mujer")) {
                    saludo = "Buenas tardes señora " + nombre + "!";
                }
            } else {
                if (sexo.equals("hombre")) {
                    saludo = "Buenas noches señor " + nombre + "!";
                } else if (sexo.equals("mujer")) {
                    saludo = "Buenas noches señora " + nombre + "!";
                }
            }
            
            out.println("<p>" + saludo + "</p>");
        }
    %>
</body>
</html>