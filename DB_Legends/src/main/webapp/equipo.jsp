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
        <link rel="stylesheet" href="css/equipo.css"/>
        <title>equipo</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
            byte[] array = (byte[]) session.getAttribute("equipo");
            List<personaje> equipo_pj = (List<personaje>) user.deserializar_pjs(array);
        %>
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">

                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Equipo</h1>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th class="text-center" style=" background-color: #ffc107 ">Id Personaje</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Nombre</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Titulo</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Tipo</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Nivel</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Salud</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Daño Fisico</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Defensa Fisica</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Daño Energia</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Defensa Energia</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Soul</th>
                                <th class="text-center" style=" background-color: #ffc107 ">Estrellas</th>
                                <!--<th class="text-center" style=" background-color: #ffc107 ">Chek</th>-->
                            </tr>
                        </thead>
                        <tbody>
                            <% for (personaje pj : equipo_pj) {%>
                            <tr>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getIdPersonaje()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getNombre()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getTitulo()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getTipo()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getNivel()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getSalud()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getDanioFisico()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getDefensaFisico()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getDanioEnergia()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getDefensaEnergia()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getSoul()%></td>
                                <td class="text-center" style="background-color: #fff3cd;"><%= pj.getEstrellas()%></td>
                                <!--                        <td class="text-center" style="background-color: #fff3cd;">
                                                            <div class="container d-flex align-items-center">
                                                                <label class="container mb-0 d-flex align-items-center">
                                                                    checked="checked"
                                                                    <input type="checkbox" name="ids" id="<%= pj.getIdPersonaje()%>" value="<%= pj.getIdPersonaje()%>">
                                                                    <div class="checkmark"></div>
                                                                </label>
                                                            </div>
                                                        </td>-->
                            </tr>
                            <% }
                            %>
                        </tbody>
                    </table>
                </div>
                <script>
                    $(document).ready(function () {
                        var checkboxes = $('input[type="checkbox"]');
                        var selectedCheckboxes = [];

                        checkboxes.change(function () {
                            selectedCheckboxes = checkboxes.filter(':checked');
                            if (selectedCheckboxes.length === 6) {
                                var ids = selectedCheckboxes.map(function () {
                                    return this.value;
                                }).get();
                                console.log("IDs seleccionados:");
                                for (var i = 0; i < ids.length; i++) {
                                    console.log(ids[i]);
                                }
                                // Enviar los IDs al servidor
                                $.ajax({
                                    type: 'POST',
                                    url: "/DB_Legends/guardarEquipos?ids=" + ids.join(","),
                                    data: {ids: ids},
                                    success: function (response) {
                                        // Manejar la respuesta del servidor si es necesario
                                        for (var i = 0; i < response.length; i++) {
                                            console.log("ID recibido: " + response[i]);
                                        }
                                    }
                                });
                            }
                        });
                    });
                </script>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
