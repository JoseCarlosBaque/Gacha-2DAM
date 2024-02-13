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
        <link rel="stylesheet" href="css/perfil.css"/>
        <title>Perfil</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
            byte[] pj = (byte[]) session.getAttribute("equipo");
            List<personaje> pjs = (List<personaje>) user.deserializar_pjs(pj);
            byte[] item = (byte[]) session.getAttribute("misItems");
            List<item> items = (List<item>) user.deserializar_items(item);
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Datos del Jugador</h1>
        <div class="ms-5 d-flex text-left">
            <label onclick="mostarId()">Toca para ver el id:</label>
            <label id="idToShow" style="display:none;">&nbsp<%= user.getIdUsuario()%></label>
        </div>
        <div class="d-flex justify-content-center align-items-center">
            <div class="flip-card">
                <div class="flip-card-inner">
                    <div class="flip-card-front">
                        <p class="title"><%= user.getUsuario()%></p>
                        <p>Nivel: <%= user.getNivel()%> Exp: <%= user.getExperiencia()%></p>
                    </div>
                    <div class="flip-card-back">
                        <label>Personajes Obtenidos:</label>
                        <label><%= pjs.size()%></label>
                        <%for (int i = 0; i < items.size(); i++) {%>
                        <label><%= items.get(i).getNombre()%>:</label>
                        <label><%= items.get(i).getCantidad()%></label>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Editar Datos Personales
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Editar Datos Personales</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/DB_Legends/editar">
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" name="contra">
                                </div>
                                <button type="submit" class="btn btn-primary" style="float: right">Confirmar</button>
                            </form>
                        </div>
<!--                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
