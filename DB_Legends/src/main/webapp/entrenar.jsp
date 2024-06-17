<%-- 
    Document   : entrenar
    Created on : 28-abr-2024, 11:41:38
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/tienda.css"/>
        <title>Entrenar</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">
                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Entrenamiento</h1>
                <%            usuario user = (usuario) session.getAttribute("user");
                    byte[] array = (byte[]) session.getAttribute("misItems");
                    List<item> mis_items = (List<item>) user.deserializar_items(array);
                %>
                <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">
                    <div class="cards">
                        <div class="card red">
                            <p class="tip"><%= mis_items.get(5).getNombre()%></p>
                            <p class="second-text"><a href="entrenamiento.jsp?id=5" style="text-decoration: none;color: white;">ENTRENAMIENTO BASICO</a></p>
                        </div>
                        <div class="card blue">
                            <p class="tip"><%= mis_items.get(4).getNombre()%></p>
                            <p class="second-text"><a href="entrenamiento.jsp?id=4" style="text-decoration: none;color: white;">ENTRENAMIENTO NORMAL</a></p>
                        </div>
                        <div class="card green">
                            <p class="tip"><%= mis_items.get(3).getNombre()%></p>
                            <p class="second-text"><a href="entrenamiento.jsp?id=3" style="text-decoration: none;color: white;">ENTRENAMIENTO AVANZADO</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
