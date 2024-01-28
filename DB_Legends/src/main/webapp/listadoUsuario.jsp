<%-- 
    Document   : listadoUsuario
    Created on : 12-nov-2023, 16:55:32
    Author     : joseb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/Usuario.js"></script>
        <title>Listado Usuario</title>
    </head>
    <body>
<!--        <form action="/DB_Legends/usuarios" method="post" class="d-felx justify-content-center">
            <h1 class="text-center">REGISTRO</h1>
            <div class="form-group">
                <label for="nombre">Nombre*</label>
                <input type="text" class="form-control" name="usuario" id="usuario" value="">
            </div>
            <div class="form-group">
                <label for="contrasenia">Contraseña*</label>
                <input type="password" class="form-control" name="password" id="password" value="">
            </div>
            <div class="form-group d-flex">
                <label for="">Tecnologias de internet*</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="tec" id="tec" value="java">
                    <label class="form-check-label" for="">
                        java
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="tec" id="tec" value=".NET">
                    <label class="form-check-label" for="">
                        .NET
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="tec" id="tec" value="PHP">
                    <label class="form-check-label" for="">
                        PHP
                    </label>
                </div>
            </div>
            <div class="form-group d-flex flex-row">
                <label for="">Genero*</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="genero" id="genero" value="Hombre">
                    <label class="form-check-label" for="opcion1">
                        Hombre
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="genero" id="genero" value="Mujer">
                    <label class="form-check-label" for="opcion2">
                        Mujer
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="">Profesion*</label>
                <select name="profesion" id="profesion">
                    <option value="">Seleccionar</option>
                    <option value="estudiante">Estudiante</option>
                    <option value="licenciado">Licenciado</option>
                    <option value="ingeniero">Ingeniero</option>
                </select>
            </div>
            <div class="form-group">
                <label for="">Musica favorita</label>
                <select name="musica" size="5" multiple>
                    <option value="rock">Rock</option>
                    <option value="pop">Pop</option>
                    <option value="salsa">Salsa</option>
                </select>
            </div>
            <div class="form-group">
                <label for="comentario">Comentario:</label>
                <textarea class="form-control" name="comentario" rows="4" placeholder="Escribe tu comentario aquí"></textarea>
            </div>
            <div class="form-group">
                <input type="reset" class="btn btn-secondary" value="Limpiar">
            </div>
            <div class="form-group d-flex justify-content-center pt-5">
                <input type="submit" class="btn btn-primary" name="enviar" value="Enviar Datos" onclick="return validarFormulario();">
            </div>
            <p>*Obligatorios</p>
        </form>-->
        <h1>Listado Usuario</h1>
        <ul>
            <c:forEach items="${usuarios}"  var="usuario">
                <li>${usuario.usuario}</li>
                </c:forEach>
        </ul>
        <a href="Borrar_lista_de_compra.jsp">Carro</a>
    </body>
</html>
