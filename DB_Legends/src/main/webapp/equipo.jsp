<%-- 
    Document   : equipo
    Created on : 05-feb-2024, 12:32:41
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.personaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>equipo</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
            byte[] array = (byte[]) session.getAttribute("equipo");
            List<personaje> equipo_pj = (List<personaje>) user.deserializar_pjs(array);
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Equipo</h1>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-center">Id Personaje</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Titulo</th>
                        <th class="text-center">Tipo</th>
                        <th class="text-center">Nivel</th>
                        <th class="text-center">Salud</th>
                        <th class="text-center">Daño Fisico</th>
                        <th class="text-center">Defensa Fisica</th>
                        <th class="text-center">Daño Energia</th>
                        <th class="text-center">Defensa Energia</th>
                        <th class="text-center">Soul</th>
                        <th class="text-center">Estrellas</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (personaje pj : equipo_pj) {%>
                    <tr>
                        <td class="text-center"><%= pj.getIdPersonaje()%></td>
                        <td class="text-center"><%= pj.getNombre()%></td>
                        <td class="text-center"><%= pj.getTitulo()%></td>
                        <td class="text-center"><%= pj.getTipo()%></td>
                        <td class="text-center"><%= pj.getNivel()%></td>
                        <td class="text-center"><%= pj.getSalud()%></td>
                        <td class="text-center"><%= pj.getDanioFisico()%></td>
                        <td class="text-center"><%= pj.getDefensaFisico()%></td>
                        <td class="text-center"><%= pj.getDanioEnergia()%></td>
                        <td class="text-center"><%= pj.getDefensaEnergia()%></td>
                        <td class="text-center"><%= pj.getSoul()%></td>
                        <td class="text-center"><%= pj.getEstrellas()%></td>
                    </tr>
                    <% }
                    %>
                </tbody>
            </table>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
