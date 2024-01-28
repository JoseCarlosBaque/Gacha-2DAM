
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.usuario;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuarios"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    IUsuarioService usuarioservice;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<usuario> usuarios = usuarioservice.listarUsuario();
        System.out.println("Usuarios: " + usuarios);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("listadoUsuario.jsp").forward(request, response);
//        boolean nuevo_user = true;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cooky : cookies) {
//                if(cooky.getName().equals("VisitanteRecurrente") && cooky.getValue().equals("si")) {
//                    nuevo_user = false;
//                    break;
//                }
//            }
//        }
//        String mensaje = null;
//        if (nuevo_user) {
//            Cookie visitanteCookie = new Cookie("VisitanteRecurrente", "si");
//            response.addCookie(visitanteCookie);
//            mensaje = "Gracias por visitar nuestro sitio";
//        } else {
//            mensaje = "Gracias por visitar de nuevo nuestro sitio";
//        }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.print("<html>");
//        out.print("<body>");
//        out.print(mensaje);
//        out.print("</body>");
//        out.print("</html>");
//        out.close();
        HttpSession misession = request.getSession(true);
        usuario usuario = new usuario("CHAK_JOSETE", "1234", 5);
        misession.setAttribute("Usuario", usuario);
//        PrintWriter pw = response.getWriter();
//        usuario miproducto = (usuario) misession.getAttribute("Usuario");
//        pw.println("<html><body>" + usuario.getUsuario()+ "," + usuario.getClave()+ "</body></html>");
//        pw.close();
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String usuario = request.getParameter("usuario");
//        String password = request.getParameter("password");
//        String[] tecnologias = request.getParameterValues("tec");
//        String[] genero = request.getParameterValues("genero");
//        String[] profesion = request.getParameterValues("profesion");
//        String[] musica = request.getParameterValues("musica");
//        String comentario = request.getParameter("comentario");
//        System.out.println("Usario: " + usuario);
//        System.out.println("Clave: " + password);
//        System.out.println("Tecnologias: " + Arrays.toString(tecnologias));
//        System.out.println("Genero: " + Arrays.toString(genero));
//        System.out.println("Profesion: " + Arrays.toString(profesion));
//        System.out.println("Musica: " + Arrays.toString(musica));
//        System.out.println("Comentario: " + comentario);
//        PrintWriter out = response.getWriter();
//        out.print("<html>");
//        out.print("<body>");
//        out.print("El parametro usuario es: " + usuario);
//        out.print("<br>");
//        out.print("El parametro clave es: " + password);
//        out.print("<br>");
//        out.print("El parametro tecnologias es: " + Arrays.toString(tecnologias));
//        out.print("<br>");
//        out.print("El parametro genero es: " + Arrays.toString(genero));
//        out.print("<br>");
//        out.print("El parametro profesion es: " + Arrays.toString(profesion));
//        out.print("<br>");
//        out.print("El parametro musica es: " + Arrays.toString(musica));
//        out.print("<br>");
//        out.print("El parametro comentario es: " + comentario);
//        out.print("<br>");
//        out.print("</body>");
//        out.print("</html>");
//        out.close();
//    }
    
}
