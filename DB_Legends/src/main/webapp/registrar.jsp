<%-- 
    Document   : registrar.jsp
    Created on : 15-dic-2023, 9:51:43
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <div class="col-sm-6 col-md-5 p-4 ml-5 mx-auto">
            <h1>Registrarse</h1>
            <form>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Usuario:</label>
                    <input type="text" class="form-control" id="user" name="user">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Contraseña:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Confrimar Contraseña:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-primary" name="registrar" id="registrar">Registrar</button>
            </form>
            <p>¿Ya tienes Cuenta? <a href="loggin.jsp">Iniciar Sesion</a></p>
        </div>
    </body>
</html>
