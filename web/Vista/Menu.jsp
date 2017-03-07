<%-- 
    Document   : Menu
    Created on : 16-dic-2016, 20:38:59
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body>

        <div id="formulario">

            <form action="ControladorMenu">
                <div id="botones">
                <input type="submit" name="submit" value="votar" class="boton">
                <input type="submit" name="submit" value="censo" class="boton">
                <input type="submit" name="submit" value="cierre" class="boton">
                <input type="submit" name="submit" value="baja" class="boton">
                <input type="submit" name="submit" value="salir" class="boton">
                </div>
            </form>
            
        </div>
    </body>
</html>
