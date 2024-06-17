<%-- 
    Document   : eventos
    Created on : 05-feb-2024, 18:54:48
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.item"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.evento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/banner.css"/>
        <link rel="stylesheet" href="css/eventos.css"/>
        <title>Eventos</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%    // Obtener la lista completa de eventos desde la sesión
            usuario user = (usuario) session.getAttribute("user");
            List<evento> lista = (List<evento>) session.getAttribute("eventos");
            byte[] bItem = (byte[]) session.getAttribute("misItems");
            List<item> items = (List<item>) user.deserializar_items(bItem);
        %>
        <% String mensaje = request.getParameter("ds"); %>

        <% if (mensaje != null && !mensaje.isEmpty()) {%>
        <div class="alert alert-success" role="alert" id="alerta">
            <p>Has ganado 1 <%= items.get(0).getTipo()%></p>
            <p>Has ganado 1 <%= items.get(1).getTipo()%></p>
            <p>Has ganado 1 <%= items.get(2).getTipo()%></p>
            <p>Has ganado 100 de XP</p>
        </div>
        <% }%>
        <script>
            // Función para ocultar el mensaje después de 5 segundos
            setTimeout(function () {
                var mensajeDiv = document.getElementById("alerta");
                if (mensajeDiv) {
                    mensajeDiv.style.display = "none";
                }
            }, 3000); // 1000 milisegundos = 1 segundos
        </script>
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">
                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Juega para Descubrir la historia de Dragon Ball Legends</h1>
                <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-wrap flex-row">
                    <div class="contenedor">
                        <section id="card1" class="card">
                            <path><img src="<%= lista.get(0).getFoto()%>" alt="alt" class="img-fluid d-block mx-auto"/></path>
                            <div class="card__content">
                                <p class="card__title"><%= lista.get(0).getNombre()%></p>
                                <p class="card__description">
                                    <%= lista.get(0).getDescripcion()%>
                                </p>
                                <a href="evento.jsp?id=0" style="text-decoration: none; color: black;">Jugar</a>
                        </section>
                    </div>
                    <div class="contenedor">
                        <section id="card1" class="card">
                            <path><img src="<%= lista.get(1).getFoto()%>" alt="alt" class="img-fluid d-block mx-auto"/></path>
                            <div class="card__content">
                                <p class="card__title"><%= lista.get(1).getNombre()%></p>
                                <p class="card__description">
                                    <%= lista.get(1).getDescripcion()%>
                                </p> 
                                <a href="evento.jsp?id=1" style="text-decoration: none; color: black">Jugar</a>
                            </div>
                        </section>
                    </div>
                    <div class="contenedor">
                        <section id="card1" class="card">
                            <path><img src="<%= lista.get(2).getFoto()%>" alt="alt" class="img-fluid d-block mx-auto"/></path>
                            <div class="card__content">
                                <p class="card__title"><%= lista.get(2).getNombre()%></p>
                                <p class="card__description">
                                    <%= lista.get(2).getDescripcion()%>
                                </p>
                                <a href="evento.jsp?id=2" style="text-decoration: none; color: black">Jugar</a>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
