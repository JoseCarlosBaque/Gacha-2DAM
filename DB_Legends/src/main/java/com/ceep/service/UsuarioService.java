/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IUsuarioDAO;
import com.ceep.dominio.usuario;
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
    public List<usuario> listarUsuario() {
        return usuariodao.findAllUsuario();
    }

    @Override
    public usuario encontrarUsuarioId(usuario usuario) {
        return usuariodao.findUsuarioId(usuario);
    }

    @Override
    public void insertarUsuario(usuario usuario) {
        usuariodao.insertarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(usuario usuario) {
        usuariodao.updateUser(usuario);
    }

    @Override
    public void borrarUsuario(usuario usuario) {
        usuariodao.borrarUsuario(usuario);
    }
    
}
