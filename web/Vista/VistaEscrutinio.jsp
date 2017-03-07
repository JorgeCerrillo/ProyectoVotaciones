<%-- 
    Document   : VistaEscrutinio
    Created on : 18-dic-2016, 18:52:30
    Author     : Jorge
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Partido"%>
<%

    HttpSession sesion = request.getSession(true);
    String mensaje = (String) sesion.getAttribute("mensaje");
    ArrayList<Partido> partidos = (ArrayList) sesion.getAttribute("escrutinio");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estiloResultados.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="resultados">
            <table class="tabla">
                <% for (int i = 0; i < partidos.size(); i++) {%>  
                <tr>
                    
                    <td><%=partidos.get(i).getNombre()%> </td>
                    <td><%=partidos.get(i).getVotos()%> </td>

                </tr>
                <% }%>

            </table>
            <form action="ControladorVolverMenu">


                <input class="boton" type="submit" name="submit" value="Volver">

            </form>
        </div>    
    </body>
</html>
