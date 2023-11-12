/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IUsuarioDAO;
import com.ceep.dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
@Stateless
public class UsuarioService implements IUsuarioService{

    @Inject
    private IUsuarioDAO usuariodao;
    
    @Override
    public List<Usuario> listarUsuario() {
        return usuariodao.findAllUsuario();
    }

    @Override
    public Usuario encontrarUsuarioId(Usuario usuario) {
        return usuariodao.findUsuarioId(usuario);
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        usuariodao.insertarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuariodao.actualizarUsuario(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        usuariodao.borrarUsuario(usuario);
    }
    
}
