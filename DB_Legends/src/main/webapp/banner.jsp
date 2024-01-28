<%-- 
    Document   : banner
    Created on : 25-ene-2024, 9:28:21
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.banner"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/banner.css"/>
        <title>Banners</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%    // Obtener la lista completa de banners desde la sesión
            List<banner> lista = (List<banner>) session.getAttribute("banners");
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Consigue Personajes Increibles</h1>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-wrap flex-row">
            <div class="contenedor">
                <section id="card1" class="card">
                    <path><img src="img/Banner1.png" alt="alt" class="img-fluid d-block mx-auto"/></path>
                    <div class="card__content">
                        <p class="card__title"><%= lista.get(0).getNombre()%></p>
                        <p class="card__description">
                            <%= lista.get(0).getDescripcion()%>
                        </p>
                        <a href="summon.jsp?id=0" class="nav-link">Ir A tirar</a>
                        </form>
                </section>
            </div>
            <div class="contenedor">
                <section id="card1" class="card">
                    <path><img src="img/Banner2.png" alt="alt" class="img-fluid d-block mx-auto"/></path>
                    <div class="card__content">
                        <p class="card__title"><%= lista.get(1).getNombre()%></p>
                        <p class="card__description">
                            <%= lista.get(1).getDescripcion()%>
                        </p>
                        <a href="summon.jsp?id=1">Ir A tirar</a>
                    </div>
                </section>
            </div>
            <div class="contenedor">
                <section id="card1" class="card">
                    <path><img src="img/Banner3.png" alt="alt" class="img-fluid d-block mx-auto"/></path>
                    <div class="card__content">
                        <p class="card__title"><%= lista.get(2).getNombre()%></p>
                        <p class="card__description">
                            <%= lista.get(2).getDescripcion()%>
                        </p>
                        <a href="summon.jsp?id=2">Ir A tirar</a>
                    </div>
                </section>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
