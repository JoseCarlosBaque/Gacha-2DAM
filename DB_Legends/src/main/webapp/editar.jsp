<%-- 
    Document   : editar
    Created on : 11-feb-2024, 22:33:26
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Datos Personales</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Datos Personales</h1>
        <div class="container">
            <form action="/DB_Legends/editar">
                <div class="form-control mb-3">
                    <label class="form-label">Nombre De Usuario</label>
                    <input type="text" class="form-control mb-3" name="nvUser" value="<%= user.getUsuario()%>">
                    <label class="form-label">Contraseña</label>
                    <input type="password" class="form-control mb-3" name="nvClave" value="<%= user.getClave()%>">
                    <button type="submit" name="enviar" class="btn btn-primary">Editar</button>
                </div>
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
