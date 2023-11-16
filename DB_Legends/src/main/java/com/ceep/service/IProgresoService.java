/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.progreso;
import com.ceep.dominio.usuario;

/**
 *
 * @author joseb
 */
public interface IProgresoService {
    public progreso findProgresoId(usuario usuario);
    
    public void insertarProgeso(progreso progreso, usuario usuario);
    
    public void actualizarProgeso(progreso progreso, usuario usuario);
    
    public void eliminarProgeso(progreso progreso, usuario usuario);
}
