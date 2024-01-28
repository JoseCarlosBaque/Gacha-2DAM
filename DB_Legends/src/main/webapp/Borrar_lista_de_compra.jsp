<%-- 
    Document   : Borrar_lista_de_compra
    Created on : 12-dic-2023, 10:38:24
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de compras</h1>
        <form action="/DB_Legends/carrito" method="post" class="d-felx justify-content-center">
            <div class="form-group">
                <label for="producto">Producto</label>
                <input type="text" class="form-control" name="producto" id="producto" value="">
            </div>
            <div class="form-group d-flex justify-content-center pt-5">
                <input type="submit" class="btn btn-primary" name="enviar" value="Enviar Datos">
            </div>
        </form>
    </body>
</html>
