<%-- 
    Document   : VistaListado
    Created on : 18-dic-2016, 18:52:14
    Author     : Jorge
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Votante"%>
<%
    
    HttpSession sesion=request.getSession(true);
   String mensaje = (String) sesion.getAttribute("mensaje");
   ArrayList<Votante> listado=(ArrayList)sesion.getAttribute("listado");
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
                <tr>
                    <td>DNI</td>
                    <td>Votado</td>
                    
                </tr>
                <% for (int i = 0; i < listado.size(); i++) {%>  
                <tr>
                    
                    <td><%=listado.get(i).getDni()%> </td>
                    <td><%=listado.get(i).isVotado() %> </td>

                </tr>
                <% }%>

            </table>
            <form action="ControladorVolverMenu">


                <input class="boton" type="submit" name="submit" value="Volver">

            </form>
        </div>    
        
        
        
    </body>
</html>
