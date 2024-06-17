<%-- 
    Document   : entrenamiento
    Created on : 28-abr-2024, 12:08:42
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
        <title>Entrenamiento</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
            byte[] array = (byte[]) session.getAttribute("equipo");
            List<personaje> equipo_pj = (List<personaje>) user.deserializar_pjs(array);
            int index = Integer.parseInt(request.getParameter("id"));
            byte[] array1 = (byte[]) session.getAttribute("misItems");
            List<item> mis_items = (List<item>) user.deserializar_items(array1);
            int i = 0;
        %>
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">
                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Entrenamiento con <%= mis_items.get(index).getNombre()%></h1>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th class="text-center" style="background-color: #001449; color: white">Id Personaje</th>
                                <th class="text-center" style="background-color: #001449; color: white">Nombre</th>
                                <th class="text-center" style="background-color: #001449; color: white">Titulo</th>
                                <th class="text-center" style="background-color: #001449; color: white">Tipo</th>
                                <th class="text-center" style="background-color: #001449; color: white">Nivel</th>
                                <th class="text-center" style="background-color: #001449; color: white">Salud</th>
                                <th class="text-center" style="background-color: #001449; color: white">Daño Fisico</th>
                                <th class="text-center" style="background-color: #001449; color: white">Defensa Fisica</th>
                                <th class="text-center" style="background-color: #001449; color: white">Daño Energia</th>
                                <th class="text-center" style="background-color: #001449; color: white">Defensa Energia</th>
                                <th class="text-center" style="background-color: #001449; color: white">Soul</th>
                                <th class="text-center" style="background-color: #001449; color: white">Entrenar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (personaje pj : equipo_pj) {%>
                            <tr>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getIdPersonaje()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getNombre()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getTitulo()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getTipo()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getNivel()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getSalud()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getDanioFisico()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getDefensaFisico()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getDanioEnergia()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getDefensaEnergia()%></td>
                                <td class="text-center" style="background-color: #66ccff"><%= pj.getSoul()%></td>
                                <td class="text-center" style="background-color: #66ccff">
                                    <a class="btn btn-primary" href="/DB_Legends/entrenamiento?id=<%= index%>&idpj=<%= i%>">Entrenar</a>
                                </td>
                            </tr>
                            <% i++;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
