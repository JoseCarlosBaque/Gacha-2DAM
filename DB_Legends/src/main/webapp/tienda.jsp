<%-- 
    Document   : tienda
    Created on : 11-feb-2024, 13:37:39
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.tienda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/tienda.css"/>
        <title>Tiendas</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%    // Obtener la lista completa de tiendas desde la sesión
            List<tienda> lista = (List<tienda>) session.getAttribute("tiendas");
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Tiendas</h1>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">
            <div class="cards">
                <div class="card red">
                    <p class="tip"><%= lista.get(0).getNombre()%></p>
                    <p class="second-text"><a href="comprar.jsp?id=0" style="text-decoration: none;color: white;">IR A LA TIENDA</a></p>
                </div>
                <div class="card blue">
                    <p class="tip"><%= lista.get(1).getNombre()%></p>
                    <p class="second-text"><a href="comprar.jsp?id=1" style="text-decoration: none;color: white;">IR A LA TIENDA</a></p>
                </div>
                <div class="card green">
                    <p class="tip"><%= lista.get(2).getNombre()%></p>
                    <p class="second-text"><a href="comprar.jsp?id=2" style="text-decoration: none;color: white;">IR A LA TIENDA</a></p>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
