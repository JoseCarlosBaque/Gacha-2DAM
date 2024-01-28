<%-- 
    Document   : navbar
    Created on : 23-ene-2024, 9:55:46
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<body>
    <%@ include file="scripts.jsp" %>
    <%
        //Validar si hay una sesion activa
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("clave") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="navbar-nav">
                <a class="navbar-item" href="index.jsp">
                    <img src="img/Login.png" alt="Dragon Ball Legends" width="30" height="24">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Menu
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Equipo</a></li>
                            <li><a class="dropdown-item" href="#">Entrenar</a></li>
                            <li><a class="dropdown-item" href="#">Personajes</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><%= sesion.getAttribute("usuario")%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/DB_Legends/summon?llenar=true">Banners</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Eventos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Tienda</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sobre Nosotros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp?cerrar=true">Cerrar Sesion</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
