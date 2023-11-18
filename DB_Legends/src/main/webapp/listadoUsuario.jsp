<%-- 
    Document   : listadoUsuario
    Created on : 12-nov-2023, 16:55:32
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Usuario</title>
    </head>
    <body>
        <h1>Listado Usuario</h1>
        <ul>
            <c:forEach items="${usuarios}"  var="usuario">
                <li>${usuario.usuario}</li>
            </c:forEach>
        </ul>
    </body>
</html>
