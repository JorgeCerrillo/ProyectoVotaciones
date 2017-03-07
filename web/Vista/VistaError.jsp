<%-- 
    Document   : VistaError
    Created on : 17-dic-2016, 17:47:40
    Author     : Jorge
--%>
<%
    HttpSession sesion=request.getSession(true);
   String mensaje = (String) sesion.getAttribute("mensaje");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <h1><%=mensaje%></h1> <br>
        <form action="ControladorError">
            <input type="submit" name="submit" value="volver">
        </form>
    </body>
</html>
