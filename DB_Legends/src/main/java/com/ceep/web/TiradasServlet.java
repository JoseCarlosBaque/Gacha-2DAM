/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.banner;
import com.ceep.dominio.item;
import com.ceep.dominio.personaje;
import com.ceep.dominio.usuario;
import com.ceep.service.IUsuarioService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
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
@WebServlet(name = "TiradasServlet", urlPatterns = {"/tiradas"})
public class TiradasServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, CloneNotSupportedException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        usuario user = (usuario) session.getAttribute("user");
        List<banner> lista = (List<banner>) session.getAttribute("banners");
        int index = (Integer) session.getAttribute("index");
        int x = (Integer) session.getAttribute("random");
        byte[] pjBanner = lista.get(index).getLista();
        List<personaje> lista_banner = lista.get(index).deserializar(pjBanner);
        byte[] misItems = (byte[]) session.getAttribute("misItems");
        List<item> ds = (List<item>) user.deserializar_items(misItems);
        byte[] pjUser = (byte[]) session.getAttribute("equipo");
        boolean encontrado = false;
        int i = 0;
        List<personaje> pjs = user.deserializar_pjs(pjUser);
        if (ds.get(0).getCantidad() >= 1) {
            ds.get(0).setCantidad(ds.get(0).getCantidad() - 1);
            for (i = 0; i < pjs.size(); i++) {
                String pjE = pjs.get(i).getNombre();
                String pjB = lista_banner.get(x).getNombre();
                if (Objects.equals(pjs.get(i).getIdPersonaje(), lista_banner.get(x).getIdPersonaje())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == true) {
                if (pjs.get(i).getTipo().equals("HE")) {
                    pjs.get(i).setSoul(pjs.get(i).getSoul() + 100);
                } else if (pjs.get(i).getTipo().equals("EX")) {
                    pjs.get(i).setSoul(pjs.get(i).getSoul() + 300);
                } else if (pjs.get(i).getTipo().equals("SP")) {
                    pjs.get(i).setSoul(pjs.get(i).getSoul() + 600);
                }
            } else {
                personaje pj = (personaje) lista_banner.get(x).clone();
                pjs.add(pj);
            }
            byte[] actualizaDs = user.serializar_items(ds);
            user.setListaItems(actualizaDs);
            session.setAttribute("misItems", actualizaDs);
            byte[] actualizarPj = user.serializar_pjs(pjs);
            user.setListaPersonajes(actualizarPj);
            session.setAttribute("equipo", actualizarPj);
            session.setAttribute("user", user);
            usuarioService.actualizarUsuario(user);
            response.sendRedirect("banner.jsp");
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
            Logger.getLogger(TiradasServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TiradasServlet.class.getName()).log(Level.SEVERE, null, ex);
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
