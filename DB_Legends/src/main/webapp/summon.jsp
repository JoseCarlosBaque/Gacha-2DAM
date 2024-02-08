<%-- 
    Document   : Summon
    Created on : 28-ene-2024, 16:31:02
    Author     : joseb
--%>

<%@page import="com.ceep.service.IUsuarioService"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.ObjectOutput"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="com.ceep.dominio.item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.personaje"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.ObjectInput"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="com.ceep.dominio.banner"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/summon.css"/>
        <title>Tiradas</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            List<banner> lista = (List<banner>) session.getAttribute("banners");
            usuario user = (usuario) session.getAttribute("user");
            Integer index = Integer.parseInt(request.getParameter("id"));
            session.setAttribute("index", index);
            byte[] pjBanner = lista.get(index).getLista();
            List<personaje> lista_banner = lista.get(index).deserializar(pjBanner);
            request.setAttribute("personajes", lista_banner);
            session.setAttribute("personajes", lista_banner);
            byte[] misItems = (byte[]) sesion.getAttribute("misItems");
            List<item> ds = (List<item>) user.deserializar_items(misItems);
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center"><%= lista.get(index).getNombre()%></h1>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-wrap flex-row position-relative">
            <div class="contenedor">
                <img src="<%= lista.get(index).getFoto()%>" alt="alt" class="img-fluid d-block mx-auto"/>
                <div class="tooltip-container position-absolute top-0">
                    <span class="tooltip">Dragon Stone</span>
                    <span class="text"><img src="img/ds.png" alt="Dragon Stone" class="img-fluid d-block mx-auto small-image"/></span>
                    <span><%= ds.get(0).getNombre()%> || <%=  ds.get(0).getCantidad()%></span>
                </div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary position-absolute top-0 end-0 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="openModal('personajes')">
                    Lista de Personajes
                </button>
                <% if (ds.get(0).getCantidad() >= 1) { %>
                <button type="button" class="btn btn-primary position-absolute top-100 end-50 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="openModal('single')">
                    Invocacion x1
                </button>
                <% } else { %>
                <button type="button" class="btn btn-primary position-absolute top-100 end-50 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="openModal('single')" disabled>
                    Invocacion x1
                </button>
                <% } %>
                <% if (ds.get(0).getCantidad() >= 50) { %>
                <button type="button" class="btn btn-primary position-absolute top-100 start-50 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="openModal('multi')">
                    Invocacion Multiple X50
                </button>
                <% } else { %>
                <button type="button" class="btn btn-primary position-absolute top-100 start-50 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="openModal('multi')" disabled>
                    Invocacion Multiple X50
                </button>
                <% } %>
            </div>
            <!-- Lista Personajes -->
            <div id="personajes" class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title fs-5" id="staticBackdropLabel">Lista de Personajes</h2>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <c:forEach items="${personajes}"  var="personaje">
                                <li>${personaje.tipo} || ${personaje.nombre}</li>
                                </c:forEach>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Single -->
            <div id="single" class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title fs-5" id="staticBackdropLabel">Lista de Personajes</h2>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="location.reload();"></button>
                        </div>
                        <div class="modal-body">
                            <%
                                Integer x = (int) (Math.floor(Math.random() * (lista_banner.size())));
                                session.setAttribute("random", x);
                            %>
                            <p><%= lista_banner.get(x).getTipo()%> || <%= lista_banner.get(x).getNombre()%></p>
                        </div>
                        <div class="modal-footer">
                            <form action="/DB_Legends/tiradas">
                                <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Multi -->
            <div id="multi" class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title fs-5" id="staticBackdropLabel">Lista de Personajes</h2>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="location.reload();"></button>
                        </div>
                        <div class="modal-body">
                            <%
//                                if (ds.get(0).getCantidad() >= 50) {
//                                    for (int i = 0; i < 10; i++) {
//                                        x = (int) (Math.floor(Math.random() * (lista_banner.size())));
//                                        ds.get(0).setCantidad(ds.get(0).getCantidad() - 50);
//                                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                                            try (ObjectOutput es = new ObjectOutputStream(bos)) {
//                                                es.writeObject(ds);
//                                                byte[] serializedArray = bos.toByteArray();
//                                                session.setAttribute("misItems", serializedArray);
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
%>
                            <p><%= lista_banner.get(x).getTipo()%> || <%= lista_banner.get(x).getNombre()%></p>
                            <%
//                                    for (int j = 0; j < 10; j++) {
//                                        if (pjs.get(j).getNombre().equals(lista_banner.get(x).getNombre())) {
//                                            if (pjs.get(i).getTipo().equals("HE")) {
//                                                pjs.get(i).setSoul(pjs.get(i).getSoul() + 100);
//                                            } else if (pjs.get(i).getTipo().equals("EX")) {
//                                                pjs.get(i).setSoul(pjs.get(i).getSoul() + 300);
//                                            } else if (pjs.get(i).getTipo().equals("SP")) {
//                                                pjs.get(i).setSoul(pjs.get(i).getSoul() + 600);
//                                            }
//                                            bos = new ByteArrayOutputStream();
//                                            try (ObjectOutput es = new ObjectOutputStream(bos)) {
//                                                es.writeObject(pjs);
//                                                byte[] serializedArray = bos.toByteArray();
//                                                session.setAttribute("equipo", serializedArray);
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
//                                        } else {
//                                            personaje newPj = (personaje) lista_banner.get(x).clone();
//                                            pjs.add(newPj);
//                                            bos = new ByteArrayOutputStream();
//                                            try (ObjectOutput es = new ObjectOutputStream(bos)) {
//                                                es.writeObject(pjs);
//                                                byte[] serializedArray = bos.toByteArray();
//                                                session.setAttribute("equipo", serializedArray);
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    }
//                                }
//                            } else {%>
                            <!--<p>No tienes suficientes Dragon Stone-->
                            <%
//                                }%>
                        </div>
                        <div class="modal-footer">
                            <!--<form action="/DB_Legends/tiradas">-->
                            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                            <!--</form>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
