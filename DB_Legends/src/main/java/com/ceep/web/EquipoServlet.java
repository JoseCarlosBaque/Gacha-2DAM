package com.ceep.web;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.ceep.dominio.personaje;
import com.ceep.dominio.usuario;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/guardarEquipos"})
public class EquipoServlet extends HttpServlet {

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
        byte[] byte_pj = (byte[]) session.getAttribute("equipo");
        List<personaje> pjs = (List<personaje>) user.deserializar_pjs(byte_pj);
        List<personaje> equipo_pjs = new ArrayList<>();
        List<byte[]> cod_pjs = new ArrayList<>();
        byte[] cod_equipo = (byte[]) session.getAttribute("equipos");
        if (cod_equipo != null) {
            cod_pjs = (List<byte[]>) user.deserializar_equipos(cod_equipo);
        } else {
            cod_pjs.add(byte_pj);
        }
        String[] ids = request.getParameterValues("ids");
        String[] idsSeparados = ids[0].split(",");
        // Recorrer la lista de pjs en busca de coincidencias
        for (int i = 0; i < idsSeparados.length; i++) {
            for (int j = 0; j < pjs.size(); j++) {
                if (Objects.equals(Integer.valueOf(idsSeparados[i]), pjs.get(j).getIdPersonaje())) {
                    equipo_pjs.add(pjs.get(j));
                    break;
                }  
            }
        }
        //Serializamos el queipo par añadirlo a List de byte[]
        byte[] equiposBytes = user.serializar_pjs(equipo_pjs);
        //Si ha mas de 6 equipos se borra el ultimo y se añadel nuevo sino solo se añade el nuevo 
        if (cod_pjs.size() == 6) {
            cod_pjs.remove(cod_pjs.size() - 1);
            cod_pjs.add(equiposBytes);
            //Serializamos el List de byte[] y lo seteamos al user y a la sesion y lo guardamos en la base de datos
            byte[] byte_equipos = user.serializar_equipos(cod_pjs);
            user.setListaEquipos(byte_equipos);
            session.setAttribute("equipos", byte_equipos);
            usuarioService.actualizarUsuario(user);
            response.sendRedirect("index.jsp");
        } else {
            cod_pjs.add(equiposBytes);
            //Serializamos el List de byte[] y lo seteamos al user y a la sesion y lo guardamos en la base de datos
            byte[] byte_equipos = user.serializar_equipos(cod_pjs);
            user.setListaEquipos(byte_equipos);
            session.setAttribute("equipos", byte_equipos);
            usuarioService.actualizarUsuario(user);
            response.sendRedirect("eventos.jsp");
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
            Logger.getLogger(EquipoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EquipoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
