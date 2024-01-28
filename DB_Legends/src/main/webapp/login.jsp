<%-- 
    Document   : loggin
    Created on : 15-dic-2023, 10:10:20
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css"/>
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <%@ include file="scripts.jsp" %>
        <%
            if (request.getParameter("cerrar") != null) {
                session.invalidate();
                response.sendRedirect("login.jsp");
            }
        %>
        <% if (request.getParameter("error") != null) { %>
        <script>
            alert('Error al iniciar sesion');
        </script>
        <% } %>
        <% if (request.getParameter("errorc") != null) { %>
        <script>
            alert('Las contraseñas no coinciden');
        </script>
        <% } %>
        <div class="wrapper col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center" style="margin-top: 10%">
            <div class="card-switch">
                <label class="switch">
                    <input type="checkbox" class="toggle">
                    <span class="slider"></span>
                    <span class="card-side"></span>
                    <div class="flip-card__inner">
                        <div class="flip-card__front">
                            <div class="title">Iniciar Sesion</div>
                            <form class="flip-card__form" action="/DB_Legends/login">
                                <input class="flip-card__input" name="user" placeholder="Usuario" type="text">
                                <input class="flip-card__input" name="password" placeholder="Contraseña" type="password">
                                <button class="flip-card__btn" name="enviarL">Iniciar Sesion</button>
                            </form>
                        </div>
                        <div class="flip-card__back">
                            <div class="title">Registrarse</div>
                            <form class="flip-card__form" action="/DB_Legends/registrarse">
                                <input class="flip-card__input" name="user1" placeholder="Usuario" type="text">
                                <input class="flip-card__input" name="password1" placeholder="Contaseña" type="password">
                                <input class="flip-card__input" name="password2" placeholder="Confirmar contraseña" type="password">
                                <button class="flip-card__btn" name="enviarR">Registrarse</button>
                            </form>
                        </div>
                    </div>
                </label>
            </div>   
        </div>
    </body>
</html>
