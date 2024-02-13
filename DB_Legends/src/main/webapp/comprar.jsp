<%-- 
    Document   : comprar
    Created on : 11-feb-2024, 14:56:15
    Author     : joseb
--%>

<%@page import="com.ceep.dominio.item"%>
<%@page import="com.ceep.dominio.tienda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <%@ include file="scripts.jsp" %>
        <%            List<tienda> lista = (List<tienda>) session.getAttribute("tiendas");
            List<item> items = (List<item>) session.getAttribute("items");
            int index = Integer.parseInt(request.getParameter("id"));
        %>
        <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center"><%= lista.get(index).getNombre()%></h1>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Tipo</th>
                        <th class="text-center">Comprar</th>
                </thead>
                <tbody>
                    <% for (int i = 3; i < items.size(); i++) {%>
                    <tr>
                        <td class="text-center"><%= items.get(i).getNombre()%></td>
                        <td class="text-center"><%= items.get(i).getCantidad()%></td>
                        <td class="text-center">5</td>
                        <td class="text-center"><%= items.get(i).getTipo()%></td>
                        <td class="text-center">
                            <a class="btn btn-primary" href="/DB_Legends/comprar?id=<%=index%>&idItem=<%=i%>">Comprar</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
                <%@ include file="footer.jsp" %>
    </body>
</html>
