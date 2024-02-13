/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.banner;
import com.ceep.dominio.destreza;
import com.ceep.dominio.personaje;
import com.ceep.dominio.usuario;
import com.ceep.service.IBannerService;
import com.ceep.service.IDestrezaService;
import com.ceep.service.IPersonajeService;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Inject
    IUsuarioService usuarioservice;
    @Inject
    IPersonajeService personajeservice;
    @Inject
    IDestrezaService destrezaservice;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        List<usuario> usuarios = usuarioservice.listarUsuario();
        List<personaje> personajes = personajeservice.listarPersonajes();
        List<destreza> destrezas = destrezaservice.findAllDestreza();
        if (request.getParameter("enviarL") != null) {
            String user = request.getParameter("user");
            String clave = request.getParameter("password");
            for (usuario usuario : usuarios) {
                if (usuario.getUsuario().equals(user) && usuario.getClave().equals(clave)) {
                    sesion.setAttribute("id_usuario", usuario.getIdUsuario());
                    sesion.setAttribute("usuario", user);
                    sesion.setAttribute("clave", clave);
                    sesion.setAttribute("nivel", usuario.getNivel());
                    sesion.setAttribute("experiencia", usuario.getExperiencia());
                    sesion.setAttribute("equipo", usuario.getListaPersonajes());
                    sesion.setAttribute("misItems", usuario.getListaItems());
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("personajes", personajes);
                    sesion.setAttribute("destrezas", destrezas);
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
            response.sendRedirect("login.jsp?error=true");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
