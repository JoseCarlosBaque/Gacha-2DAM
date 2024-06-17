/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.item;
import com.ceep.dominio.personaje;
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
@WebServlet(name = "EntrenamientoServlet", urlPatterns = {"/entrenamiento"})
public class EntrenamientoServlet extends HttpServlet {

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
    IUsuarioService usuarioService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        usuario user = (usuario) session.getAttribute("user");
        int index = Integer.parseInt(request.getParameter("id"));//Obj entrenamiento
        int id = Integer.parseInt(request.getParameter("idpj"));//Id pj
        byte[] misItems = (byte[]) session.getAttribute("misItems");
        byte[] misPjs = (byte[]) session.getAttribute("equipo");
        List<personaje> pjs = (List<personaje>) user.deserializar_pjs(misPjs);
        List<item> objetos = (List<item>) user.deserializar_items(misItems);
        if (objetos.get(index).getCantidad() >= 1) {
            objetos.get(index).setCantidad(objetos.get(index).getCantidad() - 1);
            switch (index) {
                case 5:
                    pjs.get(id).setNivel(pjs.get(id).getNivel() + 1);
                    pjs.get(id).setDanioFisico(pjs.get(id).getDanioFisico() + 10);
                    pjs.get(id).setDanioEnergia(pjs.get(id).getDanioEnergia()+ 10);
                    pjs.get(id).setDefensaFisico(pjs.get(id).getDefensaFisico() + 10);
                    pjs.get(id).setDefensaEnergia(pjs.get(id).getDefensaEnergia()+ 10);
                    break;
                case 4:
                    pjs.get(id).setNivel(pjs.get(id).getNivel() + 3);
                    pjs.get(id).setDanioFisico(pjs.get(id).getDanioFisico() + 40);
                    pjs.get(id).setDanioEnergia(pjs.get(id).getDanioEnergia()+ 40);
                    pjs.get(id).setDefensaFisico(pjs.get(id).getDefensaFisico() + 40);
                    pjs.get(id).setDefensaEnergia(pjs.get(id).getDefensaEnergia()+ 40);
                    break;
                case 3:
                    pjs.get(id).setNivel(pjs.get(id).getNivel() + 5);
                    pjs.get(id).setDanioFisico(pjs.get(id).getDanioFisico() + 60);
                    pjs.get(id).setDanioEnergia(pjs.get(id).getDanioEnergia()+ 60);
                    pjs.get(id).setDefensaFisico(pjs.get(id).getDefensaFisico() + 60);
                    pjs.get(id).setDefensaEnergia(pjs.get(id).getDefensaEnergia()+ 60);
                    break;
                default:
                    break;
            }
            byte[] actualizaDs = user.serializar_items(objetos);
            byte[] actualizaPjs = user.serializar_pjs(pjs);
            user.setListaItems(actualizaDs);
            session.setAttribute("misItems", actualizaDs);
            user.setListaPersonajes(actualizaPjs);
            session.setAttribute("equipo", actualizaPjs);
            session.setAttribute("user", user);
            usuarioService.actualizarUsuario(user);
            response.sendRedirect("entrenar.jsp");
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
            Logger.getLogger(EntrenamientoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EntrenamientoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
