/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.usuario;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IUsuarioDAO {
    public List<usuario> findAllUsuario();
    
    public usuario findUsuarioId(usuario usuario);
    
    public usuario findUsuario(String nombre, String clave);
    
    public void insertarUsuario(usuario usuario);
    
    public void updateUser(usuario usuario);
    
    public void borrarUsuario(usuario usuario);
}
