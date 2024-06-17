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
        <div class="wrapper" style="display: flex; flex-direction: column; min-height: 100vh;">
            <div class="main" style="flex: 1">
                <h1 class="col-sm-6 col-md-5 p-4 mx-auto d-flex justify-content-center align-items-center"><%= lista.get(index).getNombre()%></h1>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th class="text-center" style="background-color:  #6600cc">Nombre</th>
                                <th class="text-center" style="background-color:  #6600cc">Cantidad</th>
                                <th class="text-center" style="background-color:  #6600cc">Precio</th>
                                <th class="text-center" style="background-color:  #6600cc">Tipo</th>
                                <th class="text-center" style="background-color:  #6600cc">Comprar</th>
                        </thead>
                        <tbody>
                            <% for (int i = 3; i < items.size(); i++) {%>
                            <tr>
                                <td class="text-center" style="background-color: #9999ff"><%= items.get(i).getNombre()%></td>
                                <td class="text-center" style="background-color: #9999ff"><%= items.get(i).getCantidad()%></td>
                                <td class="text-center" style="background-color: #9999ff">5</td>
                                <td class="text-center" style="background-color: #9999ff"><%= items.get(i).getTipo()%></td>
                                <td class="text-center" style="background-color: #9999ff">
                                    <a class="btn btn-primary" href="/DB_Legends/comprar?id=<%=index%>&idItem=<%=i%>">Comprar</a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
