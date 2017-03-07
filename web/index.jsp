<%-- 
    Document   : index
    Created on : 16-dic-2016, 19:25:15
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession(true);
    sesion.invalidate();

%> 
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estiloIndex.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div id="encabezado">

            <h1>Votaciones Partidos políticos 2016</h1>

        
        </div>


        <div id="formu">
            <h3 class="log">Login</h3>
            <form action="ControladorIndex">

                DNI:    <input type="text" name="dni" required="required">

                Password: <input type="password" name="pass" required="required">

                <input class="boton"type="submit" name="submit" value="Acceder"><br>
                <input class="boton"type="submit" name="submit" value="Registrarse"><br>
            </form>

        </div>
        
       

    </body>
</html>
