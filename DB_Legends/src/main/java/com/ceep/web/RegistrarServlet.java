/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.destreza;
import com.ceep.dominio.item;
import com.ceep.dominio.personaje;
import com.ceep.dominio.usuario;
import com.ceep.service.IDestrezaService;
import com.ceep.service.IItemService;
import com.ceep.service.IPersonajeService;
import com.ceep.service.IUsuarioService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/registrarse"})
public class RegistrarServlet extends HttpServlet {

    @Inject
    IUsuarioService usuarioservice;
    @Inject
    IPersonajeService personajeService;
    @Inject
    IItemService itemService;
    @Inject
    IDestrezaService destrezaservice;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CloneNotSupportedException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        byte[] serializedArray1 = null;
        byte[] serializedArray2 = null;
        List<usuario> usuarios = null;
        List<item> items = itemService.listar_items();
        List<personaje> personajes = personajeService.listarPersonajes();
        List<destreza> destrezas = destrezaservice.findAllDestreza();
        if (request.getParameter("enviarR") != null) {
            String user = request.getParameter("user1");
            String clave1 = request.getParameter("password1");
            String clave2 = request.getParameter("password2");
            if (clave2.equals(clave1)) {
                List<personaje> equipo = new ArrayList<>();
                List<item> misItems = new ArrayList<>();
                if (equipo.isEmpty()) {
                    personaje pjs = (personaje) personajes.get(0).clone();
                    equipo.add(pjs);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    try (ObjectOutput ot = new ObjectOutputStream(bos)) {
                        ot.writeObject(equipo);
                        serializedArray1 = bos.toByteArray();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (misItems.isEmpty()) {
                    item item1 = (item) items.get(0).clone();
                    item1.setCantidad(100);
                    item item2 = (item) items.get(1).clone();
                    item2.setCantidad(100);
                    item item3 = (item) items.get(2).clone();
                    item3.setCantidad(100);
                    misItems.add(item1);
                    misItems.add(item2);
                    misItems.add(item3);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    try (ObjectOutput ot = new ObjectOutputStream(bos)) {
                        ot.writeObject(misItems);
                        serializedArray2 = bos.toByteArray();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                usuario new_user = new usuario(user, clave1, 0,0, serializedArray1, serializedArray2);
                usuarioservice.insertarUsuario(new_user);
            } else {
                response.sendRedirect("login.jsp?errorc=true");
                return;
            }
            usuarios = usuarioservice.listarUsuario();
            if (!usuarios.isEmpty()) {
                for (usuario usuario : usuarios) {
                    if (usuario.getUsuario().equals(user) && usuario.getClave().equals(clave1)) {
                        sesion.setAttribute("id_usuario", usuario.getIdUsuario());
                        sesion.setAttribute("usuario", user);
                        sesion.setAttribute("clave", clave1);
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
        try {
            processRequest(request, response);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
