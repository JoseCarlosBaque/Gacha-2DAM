<%-- 
    Document   : evento
    Created on : 07-feb-2024, 11:10:24
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.personaje"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page import="com.ceep.dominio.destreza"%>
<%@page import="com.ceep.dominio.evento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    int index = Integer.parseInt(request.getParameter("id"));
    usuario user = (usuario) session.getAttribute("user");
    byte[] byte_equipo = (byte[]) session.getAttribute("equipo");
    List<personaje> pjs = (List<personaje>) user.deserializar_pjs(byte_equipo);
    List<evento> eventos = (List<evento>) session.getAttribute("eventos");
    List<destreza> destrezas = (List<destreza>) session.getAttribute("destrezas");
    int salud = (Integer) session.getAttribute("max_health");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/summon.css"/>
        <link rel="stylesheet" href="css/eventos.css"/>
        <title><%= eventos.get(index).getNombre()%></title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center"><%= eventos.get(index).getNombre()%></h1>
        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center flex-wrap flex-row position-relative">
            <img src="<%= eventos.get(index).getFoto()%>" alt="alt" class="img-fluid d-block mx-auto"/>
            <button style="color: black;" type="button" class="position-absolute top-100 end-70 m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                JUGAR
                <div id="clip">
                    <div id="leftTop" class="corner"></div>
                    <div id="rightBottom" class="corner"></div>
                    <div id="rightTop" class="corner"></div>
                    <div id="leftBottom" class="corner"></div>
                </div>
                <span id="rightArrow" class="arrow ms-2"></span>
                <span id="leftArrow" class="arrow"></span>
            </button>
        </div>
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title fs-5" id="staticBackdropLabel">Lista de Personajes</h2>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <p class="d-none" id="health"><%= salud%></p>
                            <div  class="progress" role="progressbar" aria-label="Success example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                <% String width = eventos.get(index).calcular_porcentaje(salud);%>
                                <div class="progress-bar bg-success" id="healthPercentage" style="width: 100%"><label id="healthPercentage">100%</label></div>
                            </div>
                        </div>
                        <div class="container mt-2">
                            <img src="img/Zamasu(Corrompido).jpg" class="img-fluid d-block mx-auto" alt="Zamasu(Corrompido)"/>
                        </div>
                        <div class="container col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">
                            <select name="index_equipo">
                                <% for (int i = 0; i < pjs.size(); i++) {%>
                                <option value="<%= pjs.get(i).getIdPersonaje()%>"><%= pjs.get(i).getNombre()%></option>   
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="container col-sm-6 col-md-12 p-4 mx-auto d-flex justify-content-center align-items-center gap-3">
                            <button type="button" id="strikeButton"><img src="<%= destrezas.get(0).getFoto()%>" alt="Strike" class="img-fluid d-block mx-auto"/></button>
                            <button type="button" id="blastButton"><img src="<%= destrezas.get(1).getFoto()%>" alt="Blast" class="img-fluid d-block mx-auto"/></button>
                            <button type="button" id="greenButton"><img src="<%= destrezas.get(2).getFoto()%>" alt="Green" class="img-fluid d-block mx-auto"/></button>
                            <button type="button" id="saButton"><img src="<%= destrezas.get(3).getFoto()%>" alt="SA" class="img-fluid d-block mx-auto"/></button>
                        </div>
                        <script>
                            // Obtener referencias a los botones
                            var strikeButton = document.getElementById("strikeButton");
                            var blastButton = document.getElementById("blastButton");
                            var greenButton = document.getElementById("greenButton");
                            var saButton = document.getElementById("saButton");
                            // Agregar manejadores de eventos a los botones
                            strikeButton.onclick = function () {
                                restarVida(1000); // Restar 20 de vida al hacer clic en el botón de Strike
                            };
                            blastButton.onclick = function () {
                                restarVida(1500); // Restar 20 de vida al hacer clic en el botón de Blast
                            };
                            greenButton.onclick = function () {
                                restarVida(0); // Restar 20 de vida al hacer clic en el botón de Green
                            };
                            saButton.onclick = function () {
                                restarVida(5000); // Restar 20 de vida al hacer clic en el botón de SA
                            };
                            // Función para restar vida
                            function restarVida(cantidad) {
                                // Obtener la vida actual
                                var vida = parseInt(document.getElementById("health").textContent);
                                // Restar la cantidad especificada
                                vida -= cantidad;
                                // Actualizar el valor de la vida en el elemento HTML
                                document.getElementById("health").textContent = vida;
                                // Calcular y mostrar el porcentaje de vida
                                var porcentaje = calcularPorcentaje(vida);
                                document.getElementById("healthPercentage").textContent = porcentaje;
                                document.getElementById("healthPercentage").style.width = porcentaje;
                            }
                            // Función para calcular el porcentaje de vida
                            function calcularPorcentaje(vida) {
                                var porcentaje = (vida / 40000) * 100;
                                var porcentajeFormateado = porcentaje.toFixed(2); // Redondeamos el resultado a dos decimales
                                if (porcentajeFormateado < 0) {
                                    porcentajeFormateado = 0; // Si es menor que cero, establecer el porcentaje en cero
                                } else if (porcentajeFormateado.endsWith('.00')) {
                                    return parseInt(porcentajeFormateado) + '%'; // Mostrar solo el número entero si los decimales son .00
                                } else {
                                    return porcentajeFormateado + '%'; // Mostrar el porcentaje con dos decimales si no termina con .00
                                }
                            }
                        </script>
<!--                        <script>
                            // Obtener la vida actual del elemento HTML
                            var vidaActual = parseInt(document.getElementById("health").textContent);
                            if (vidaActual <= 0) {
                                // Crear un objeto FormData para enviar datos al servidor
                                var formData = new FormData();
                                formData.append('vidaActual', vidaActual);
                                // Realizar una solicitud Ajax utilizando Fetch API
                                fetch('/nivelServlet', {
                                    method: 'POST',
                                    body: formData
                                })
                                        .then(response => {
                                            if (!response.ok) {
                                                throw new Error('Error al actualizar la vida');
                                            }
                                            return response.text(); // Si el servidor devuelve una respuesta
                                        })
                                        .then(data => {
                                            console.log('Vida actualizada correctamente:', data);
                                        })
                                        .catch(error => {
                                            console.error('Error al realizar la solicitud:', error);
                                        });
                            }
                        </script>-->
                    </div>
                    <div class="modal-footer">
                        <form action="/DB_Legends/nivelServlet">
                            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
