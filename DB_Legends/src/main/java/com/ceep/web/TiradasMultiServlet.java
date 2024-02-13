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
@WebServlet(name = "TiradasMultiServlet", urlPatterns = {"/tiradasMulti"})
public class TiradasMultiServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, CloneNotSupportedException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        usuario user = (usuario) session.getAttribute("user");
        List<banner> lista = (List<banner>) session.getAttribute("banners");
        int index = (Integer) session.getAttribute("index");
        List<Integer> multi = (List<Integer>) session.getAttribute("multi");
        byte[] pjBanner = lista.get(index).getLista();
        List<personaje> lista_banner = lista.get(index).deserializar(pjBanner);
        byte[] misItems = (byte[]) session.getAttribute("misItems");
        List<item> ds = (List<item>) user.deserializar_items(misItems);
        byte[] pjUser = (byte[]) session.getAttribute("equipo");
        List<personaje> pjs = user.deserializar_pjs(pjUser);
        boolean encontrado = false;
        int j;
        if (ds.get(0).getCantidad() >= 50) {
            ds.get(0).setCantidad(ds.get(0).getCantidad() - 50);
            for (int i = 0; i < multi.size(); i++) {
                encontrado = false;
                int x = multi.get(i);
                for (j = 0; j < pjs.size(); j++) {
                    if (Objects.equals(pjs.get(j).getIdPersonaje(), lista_banner.get(x).getIdPersonaje())) {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    if (pjs.get(j).getTipo().equals("HE")) {
                        pjs.get(j).setSoul(pjs.get(j).getSoul() + 100);
                    } else if (pjs.get(j).getTipo().equals("EX")) {
                        pjs.get(j).setSoul(pjs.get(j).getSoul() + 300);
                    } else if (pjs.get(j).getTipo().equals("SP")) {
                        pjs.get(j).setSoul(pjs.get(j).getSoul() + 600);
                    }
                    pjs.get(j).setEstrellas(pjs.get(j).getSoul() / 1000);
                } else {
                    personaje pj = (personaje) lista_banner.get(x).clone();
                    pjs.add(pj);
                }
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
            Logger.getLogger(TiradasMultiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TiradasMultiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
