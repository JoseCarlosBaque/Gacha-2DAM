/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.usuario;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IUsuarioService {
    public List<usuario> listarUsuario();
    
    public usuario encontrarUsuarioId(usuario usuario);
    
    public void insertarUsuario(usuario usuario);
    
    public void actualizarUsuario(usuario usuario);
    
    public void borrarUsuario(usuario usuario);
}
