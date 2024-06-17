<%-- 
    Document   : todosPersonajes
    Created on : 05-feb-2024, 18:17:08
    Author     : joseb
--%>

<%@page import="java.util.Objects"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.personaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            List<personaje> personajes = (List<personaje>) session.getAttribute("personajes");
            boolean encontrado = false;
        %>
        <div class="container mt-4">
            <form class="d-flex" action="/DB_Legends/BuscarPjServlet">
                <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar" name="buscar">
                <button class="btn btn-outline-success" type="submit">Buscar</button>
            </form>
        </div>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Lista de Todos Los Personajes</h1>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-center" style="background-color: #5ff025">Id Personaje</th>
                        <th class="text-center" style="background-color: #5ff025">Nombre</th>
                        <th class="text-center" style="background-color: #5ff025">Titulo</th>
                        <th class="text-center" style="background-color: #5ff025">Tipo</th>
                        <th class="text-center" style="background-color: #5ff025">Salud</th>
                        <th class="text-center" style="background-color: #5ff025">Daño Fisico</th>
                        <th class="text-center" style="background-color: #5ff025">Defensa Fisica</th>
                        <th class="text-center" style="background-color: #5ff025">Daño Energia</th>
                        <th class="text-center" style="background-color: #5ff025">Defensa Energia</th>
                        <th class="text-center" style="background-color: #5ff025">Soul</th>
                        <th class="text-center" style="background-color: #5ff025">Estrellas</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < personajes.size(); i++) {
                            encontrado = false;
                            for (int j = 0; j < equipo_pj.size(); j++) {
                                if (Objects.equals(equipo_pj.get(j).getIdPersonaje(), personajes.get(i).getIdPersonaje())) {
                                    encontrado = true;
                                    break;
                                }
                            }
                    %>
                    <tr>
                        <% if (encontrado) {%>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getIdPersonaje()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getNombre()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getTitulo()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getTipo()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getSalud()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getDanioFisico()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getDefensaFisico()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getDanioEnergia()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getDefensaEnergia()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getSoul()%></td>
                        <td class="text-center" style="background-color: #d2ff96; color:black"><%= personajes.get(i).getEstrellas()%></td>
                        <% } else {%>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getIdPersonaje()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getNombre()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getTitulo()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getTipo()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getSalud()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getDanioFisico()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getDefensaFisico()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getDanioEnergia()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getDefensaEnergia()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getSoul()%></td>
                        <td class="text-center" style="background-color: #ff745f; color:white"><%= personajes.get(i).getEstrellas()%></td>
                        <% } %>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
