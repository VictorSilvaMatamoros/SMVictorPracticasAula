<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<link href="../CSS/jsp/numeroOculto.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Juego de Adivina el Número</title>
    <script>
        function validarAdivinanza() {
            var adivinanza = document.getElementsByName("adivinanza")[0].value;
            if (!/^\d+$/.test(adivinanza)) {
                alert("Por favor, ingresa solo números.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h1>Juego de Adivina el Número</h1>
    <p>Estoy pensando en un número entre 1 y 100. ¡Adivina cuál es!</p>
    
    <form method="post" action="numeroOculto.jsp" onsubmit="return validarAdivinanza();">
        <input type="text" name="adivinanza" placeholder="Introduce tu adivinanza">
        <input type="submit" value="Adivinar">
    </form>
    
    <%
        // Lógica del juego
        int numeroSecreto = 0;
        int intentos = 0;
        List<Integer> intentosAnteriores = new ArrayList<>();

        // Comprobar si el número secreto ya ha sido generado
        if (session.getAttribute("numeroSecreto") == null) {
            numeroSecreto = (int) (Math.random() * 100) + 1;
            session.setAttribute("numeroSecreto", numeroSecreto);
            session.setAttribute("intentos", intentos);
        } else {
            numeroSecreto = (int) session.getAttribute("numeroSecreto");
            intentos = (int) session.getAttribute("intentos");
        }

        String adivinanzaStr = request.getParameter("adivinanza");
        if (adivinanzaStr != null && !adivinanzaStr.isEmpty()) {
            int adivinanza = Integer.parseInt(adivinanzaStr);
            intentos++;
            intentosAnteriores.add(adivinanza);
            session.setAttribute("intentos", intentos); // Actualizar el número de intentos en la sesión

            if (adivinanza == numeroSecreto) {
    %>
                <p>¡Felicidades! Has adivinado el número secreto en <%= intentos %> intentos. El número secreto era: <%= numeroSecreto %></p>
    <%
                session.removeAttribute("numeroSecreto"); // Eliminar el número secreto después de ganar
                session.removeAttribute("intentos"); // Eliminar la variable de intentos
            } else if (adivinanza < numeroSecreto) {
    %>
                <p>Intento #<%= intentos %>: El número secreto es mayor que <%= adivinanza %>. Sigue intentando.</p>
    <%
            } else {
    %>
                <p>Intento #<%= intentos %>: El número secreto es menor que <%= adivinanza %>. Sigue intentando.</p>
    <%
            }
        }
    %>
</body>
</html>
