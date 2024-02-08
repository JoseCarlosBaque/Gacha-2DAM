<%-- 
    Document   : perfil
    Created on : 06-feb-2024, 10:27:02
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.item"%>
<%@page import="com.ceep.dominio.personaje"%>
<%@page import="java.util.List"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%
            usuario user = (usuario) session.getAttribute("user");
            byte[] pj = (byte[]) session.getAttribute("equipo");
            List<personaje> pjs = (List<personaje>)  user.deserializar_pjs(pj);
            byte[] item = (byte[]) session.getAttribute("misItems");
            List<item> items = (List<item>)  user.deserializar_items(item);
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Datos del Jugador</h1>
        <div class="ms-5 d-flex text-left">
            <label onclick="mostarId()">Toca para ver el id:</label>
            <label id="idToShow" style="display:none;">&nbsp<%= user.getIdUsuario()%></label>
        </div>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-column">
            <div class="p-2">
                <label>Nombre de Usuario:</label>
                <label>&nbsp<%= user.getUsuario()%></label>
            </div>
            <div class="p-2">
                <label>Nivel:</label>
                <label>&nbsp<%= user.getNivel()%></label>
            </div>
            <div class="p-2">
                <label>Personajes Obtenidos: </label>
                <label>&nbsp<%= pjs.size() %></label>
            </div>
            <div class="p-2">
                <label><%= items.get(0).getNombre()%>:</label>
                <label>&nbsp<%= items.get(0).getCantidad() %></label>
            </div>
            <div class="p-2">
                <button type="submit" name="editar"><a href="editar_perfil.jsp" class="nav-link">Editar</a></button>
            </div>
        </div>
    </body>
</html>
