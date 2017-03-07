<%-- 
    Document   : VistaVotar
    Created on : 18-dic-2016, 18:52:02
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estiloVotar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="formula">
        <form action="ControladorVotar">

            <h3>Partidos Políticos </h3> <br/>
            <input type="radio" name="partido" value="PP" checked="checked" class="rad" /> Partido Popular<br>
            <input type="radio" name="partido" value="PSOE" class="rad" /> Partido Socialista <br>
            <input type="radio" name="partido" value="CIUDADANOS" class="rad" /> Ciudadanos <br>
            <input type="radio" name="partido" value="PODEMOS" class="rad" /> Podemos <br>
            
            <input type="submit" name="submit" value="Votar" class="boton"/>
            
        </form>
            
        </div>    
    </body>
</html>
