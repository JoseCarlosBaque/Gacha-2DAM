/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.banner;
import com.ceep.dominio.item;
import com.ceep.dominio.personaje;
import com.ceep.dominio.usuario;
import com.ceep.service.IBannerService;
import com.ceep.service.IItemService;
import com.ceep.service.IPersonajeService;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
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
@WebServlet(name = "BannerServlet", urlPatterns = {"/summon"})
public class BannerServlet extends HttpServlet {

    @Inject
    IBannerService bannerService;
    @Inject
    IItemService itemService;
    @Inject
    IUsuarioService usuarioService;
    @Inject
    IPersonajeService personajeService;

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
        HttpSession sesion = request.getSession();
        usuario user = (usuario) sesion.getAttribute("user");
        List<banner> banners = bannerService.listarBanner();
        List<item> items = itemService.listar_items();
        List<personaje> personajes = personajeService.listarPersonajes();
//        List<personaje> pj = new ArrayList<>();
//        byte[] misPjs = (byte[]) sesion.getAttribute("equipo");
//        if (misPjs == null || misPjs.length == 0) {
//            if (pj.isEmpty()) {
//                personaje pjs = (personaje) personajes.get(0).clone();
//                pj.add(pjs);
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                try (ObjectOutput ot = new ObjectOutputStream(bos)) {
//                    ot.writeObject(pj);
//                    byte[] serializedArray = bos.toByteArray();
//                    user.setListaPersonajes(serializedArray);
//                    usuario nv = new usuario(user.getIdUsuario(), user.getUsuario(), user.getClave(), user.getNivel(), serializedArray, user.getListaPersonajes());
//                    usuarioService.actualizarUsuario(nv);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        byte[] misItems = (byte[]) sesion.getAttribute("misItems");
//        if (!misItems.equals(null)) {
//            //Deserializmos la lista de item del usuario y al ser nuevo le regalamos un multisummon
//            List<item> ds = (List<item>) user.deserializar_items(misItems);// new ArrayList<item>() para los user ya existentes
//            if (ds.isEmpty()) {
//                item new_userDS = (item) items.get(0).clone();
//                new_userDS.setCantidad(50);
//                ds.add(new_userDS);
//                //Serializamos la lista de items del usuario para que pueda tirar el multi
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                try (ObjectOutput ot = new ObjectOutputStream(bos)) {
//                    ot.writeObject(ds);
//                    byte[] serializedArray = bos.toByteArray();
//                    user.setListaItems(serializedArray);
//                    usuario nv = new usuario(user.getIdUsuario(), user.getUsuario(), user.getClave(), user.getNivel(), user.getListaPersonajes(), serializedArray);
//                    usuarioService.actualizarUsuario(nv);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        List<personaje> lista = personajeService.listarPersonajes();
//        if (lista != null) {
//            List<personaje> listaBanner = new ArrayList<>();
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 20; j++) {
//                    int x = (int) (Math.floor(Math.random() * (34)));
//                    if (!(listaBanner.contains(lista.get(x))) || listaBanner.isEmpty()) {
//                        listaBanner.add(lista.get(x));
//                    }
//                }
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                try (ObjectOutput out = new ObjectOutputStream(bos)) {
//                    out.writeObject(listaBanner);
//                    byte[] serializedArray = bos.toByteArray();
//                    banners.get(i).setLista(serializedArray);
//                    banner bn = new banner(banners.get(i).getNombre(), banners.get(i).getPrecio(), banners.get(i).getStep(), banners.get(i).getProbNuevo(), banners.get(i).getProbSp(), banners.get(i).getProbEx(), banners.get(i).getProbHero(), banners.get(i).getDescripcion(), serializedArray, banners.get(i).getFoto(), banners.get(i).getIdBanner());
//                    bannerService.actualizarBanner(bn);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        if (request.getParameter("llenar") != null) {
            sesion.setAttribute("items", items);
            sesion.setAttribute("banners", banners);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BannerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BannerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BannerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BannerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
