<%-- 
    Document   : navbar
    Created on : 23-ene-2024, 9:55:46
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<body style="background-color: #65727a">
    <%@ include file="scripts.jsp" %>
    <%
        //Validar si hay una sesion activa
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("clave") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <style>
        /* Estilos para pantallas pequeñas (móviles) */
        @media (max-width: 576px) {
            nav {
                justify-content: center;
            }
            
            .navbar-nav {
                text-align: center;
            }

            .navbar-nav .nav-item {
                margin-bottom: 10px;
            }
        }
        
        /* Estilos para pantallas grandes (escritorios) */
        @media (min-width: 769px) {
            li:hover {
                background-color: white;
                color: black;
            }
        }
        </style>
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <div class="container navbar-nav">
                    <a class="navbar-item" href="index.jsp">
                        <img src="img/Login.png" alt="Dragon Ball Legends" width="60" height="auto">
                    </a>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse" id="navbarNav">
                    <ul class="navbar-nav d-flex justify-content-center align-items-center ms-5">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Menu
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="equipo.jsp">Equipo</a></li>
                                <li><a class="dropdown-item" href="entrenar.jsp">Entrenar</a></li>
                                <li><a class="dropdown-item" href="bolsa.jsp">Bolsa</a></li>
                                <li><a class="dropdown-item" href="personajes.jsp">Personajes</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="perfil.jsp"><%= sesion.getAttribute("usuario")%></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/DB_Legends/summon?llenar=true">Banners</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/DB_Legends/evento?llenar=true">Eventos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/DB_Legends/tienda?llenar=true">Tienda</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp?cerrar=true">Cerrar Sesion</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
