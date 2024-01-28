/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.usuario;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joseb
 */
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/registrarse"})
public class RegistrarServlet extends HttpServlet {

    @Inject
    IUsuarioService usuarioservice;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        List<usuario> usuarios = null;
        if (request.getParameter("enviarR") != null) {
            String user = request.getParameter("user1");
            String clave1 = request.getParameter("password1");
            String clave2 = request.getParameter("password2");
            if (clave2.equals(clave1)) {
                usuario new_user = new usuario(user, clave1, 0);
                usuarioservice.insertarUsuario(new_user);
            } else {
                response.sendRedirect("login.jsp?errorc=true");
                return;
            }
            usuarios = usuarioservice.listarUsuario();
            if (usuarios.size() > 0) {
                for (usuario usuario : usuarios) {
                    if (usuario.getUsuario().equals(user) && usuario.getClave().equals(clave1)) {
                        sesion.setAttribute("id_usuario", usuario.getIdUsuario());
                        sesion.setAttribute("usuario", user);
                        sesion.setAttribute("clave", clave1);
                        sesion.setAttribute("nivel", usuario.getNivel());
                        response.sendRedirect("index.jsp");
                        return;
                    }
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
