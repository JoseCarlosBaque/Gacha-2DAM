/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.item;
import com.ceep.dominio.usuario;
import com.ceep.service.IItemService;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
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
@WebServlet(name = "ComprarServlet", urlPatterns = {"/comprar"})
public class ComprarServlet extends HttpServlet {

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
    IItemService itemService;
    @Inject
    IUsuarioService usuarioService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, CloneNotSupportedException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        usuario user = (usuario) session.getAttribute("user");
        int index = Integer.parseInt(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("idItem"));
        byte[] misItems = (byte[]) session.getAttribute("misItems");
        List<item> items = itemService.listar_items();
        List<item> ds = (List<item>) user.deserializar_items(misItems);
        boolean encontrado = false;
        int i;
        if (ds.get(index).getCantidad() >= 5) {
            ds.get(index).setCantidad(ds.get(index).getCantidad() - 5);
            for (i = 0; i < ds.size(); i++) {
                if (Objects.equals(ds.get(i).getIdItem(), items.get(id).getIdItem())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                ds.get(i).setCantidad(ds.get(i).getCantidad() + 5);
            } else {
                item new_useitem = (item) items.get(id).clone();
                ds.add(new_useitem);
            }
            byte[] actualizaDs = user.serializar_items(ds);
            user.setListaItems(actualizaDs);
            session.setAttribute("misItems", actualizaDs);
            session.setAttribute("user", user);
            usuarioService.actualizarUsuario(user);
            response.sendRedirect("tienda.jsp");
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
        } catch (ClassNotFoundException | CloneNotSupportedException ex) {
            Logger.getLogger(ComprarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException | CloneNotSupportedException ex) {
            Logger.getLogger(ComprarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
