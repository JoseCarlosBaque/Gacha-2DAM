/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.web;

import com.ceep.dominio.Usuario;
import com.ceep.service.IUsuarioService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseb
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuarios"})
public class UsuarioServlet extends HttpServlet{
    @Inject
    IUsuarioService usuarioservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioservice.listarUsuario();
        System.out.println("Usuarios: " + usuarios);
        request.setAttribute("personas", usuarios);
        request.getRequestDispatcher("listadoUsuario.jsp").forward(request, response);
    }
}
