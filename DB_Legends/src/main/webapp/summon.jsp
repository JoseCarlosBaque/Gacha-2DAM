<%-- 
    Document   : Summon
    Created on : 28-ene-2024, 16:31:02
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.banner"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiradas</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            List<banner> lista = (List<banner>) session.getAttribute("banners");
            int index = Integer.parseInt(request.getParameter("id"));
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center"><%= lista.get(index).getNombre()%></h1>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-wrap flex-row">
            <div class="contenedor">
                <img src="img/Banner1.png" alt="alt" class="img-fluid d-block mx-auto"/>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
