/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.Usuario;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IUsuarioService {
    public List<Usuario> listarUsuario();
    
    public Usuario encontrarUsuarioId(Usuario usuario);
    
    public void insertarUsuario(Usuario usuario);
    
    public void actualizarUsuario (Usuario usuario);
    
    public void borrarUsuario(Usuario usuario);
}
