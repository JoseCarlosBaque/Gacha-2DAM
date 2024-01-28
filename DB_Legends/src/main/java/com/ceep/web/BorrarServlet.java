/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.usuario;
import javax.servlet.annotation.WebServlet;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joseb
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/carrito"})
public class BorrarServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();
        List<String> productos = (List <String>) misession.getAttribute("Productos");
        if (productos == null) {
            productos = new ArrayList<>();
        }
        String producto = request.getParameter("producto");
        if (producto != null && !producto.isEmpty()) {
            productos.add(producto);   
        }
        misession.setAttribute("Productos", productos);
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("<h1>Carrito</h1>");
        out.print("<ul>");
        for (String articulo : productos) {
            out.print("<li>" + articulo + "</li>");
        }
        out.print("</ul>");
        out.print("<a href = \"Borrar_lista_de_compra.jsp\" >Volver</a>");
        out.print("</body>");
        out.print("</html>");
//        request.getRequestDispatcher("Borrar_lista_de_compra.jsp").forward(request, response);
    }
}
