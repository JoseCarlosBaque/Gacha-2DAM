<%-- 
    Document   : bolsa
    Created on : 28-abr-2024, 11:28:32
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.item"%>
<%@page import="java.util.List"%>
<%@page import="com.ceep.dominio.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bolsa</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            usuario user = (usuario) session.getAttribute("user");
            byte[] array = (byte[]) session.getAttribute("misItems");
            List<item> mis_items = (List<item>) user.deserializar_items(array);
        %>
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">
                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center">Equipo</h1>
                <div class="container">
                    <table class="table" style="background-color: #f8f9fa;">
                        <thead>
                            <tr>
                                <th class="text-center" style="background-color: #ff00cc; color: #ffffff;">Id Item</th>
                                <th class="text-center" style="background-color: #ff00cc; color: #ffffff;">Nombre</th>
                                <th class="text-center" style="background-color: #ff00cc; color: #ffffff;">Tipo</th>
                                <th class="text-center" style="background-color: #ff00cc; color: #ffffff;">Cantidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (item item : mis_items) {%>
                            <tr>
                                <td class="text-center" style="background-color: #ff99ff; color: #000000;"><%= item.getIdItem()%></td>
                                <td class="text-center" style="background-color: #ff99ff; color: #000000;"><%= item.getNombre()%></td>
                                <td class="text-center" style="background-color: #ff99ff; color: #000000;"><%= item.getTipo()%></td>
                                <td class="text-center" style="background-color: #ff99ff; color: #000000;"><%= item.getCantidad()%></td>
                            </tr>
                            <% }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
