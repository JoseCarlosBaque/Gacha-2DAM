/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.item;
import com.ceep.dominio.usuario;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "nivelServlet", urlPatterns = {"/nivelServlet"})
public class NivelServlet extends HttpServlet {

    @Inject
    IUsuarioService usuarioService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        usuario user = (usuario) sesion.getAttribute("user");
        byte[] bItems = (byte[]) sesion.getAttribute("misItems");
        List<item> items = (List<item>) user.deserializar_items(bItems);
        if (items.get(0).getTipo().equals("Dragon Stone")) {
            items.get(0).setCantidad(items.get(0).getCantidad() + 1);
            items.get(1).setCantidad(items.get(1).getCantidad() + 1);
            items.get(2).setCantidad(items.get(2).getCantidad() + 1);
            user.setExperiencia(user.getExperiencia() + 100);
            user.setNivel(user.getExperiencia() / 1000);
            byte[] actualizar = user.serializar_items(items);
            user.setListaItems(actualizar);
            usuarioService.actualizarUsuario(user);
            sesion.setAttribute("nivel", user.getNivel());
            sesion.setAttribute("experiencia", user.getExperiencia());
            sesion.setAttribute("user", user);
            sesion.setAttribute("misItems", actualizar);
            response.sendRedirect("eventos.jsp?ds=ganaste");
        } else {
            response.sendRedirect("index.jsp");
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
            Logger.getLogger(NivelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NivelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
