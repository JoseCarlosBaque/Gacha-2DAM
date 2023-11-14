/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Progreso;
import com.ceep.dominio.Usuario;

/**
 *
 * @author joseb
 */
public interface IProgresoDAO {
    public Progreso findProgresoId(Usuario usuario);
    
    public void insertarProgeso(Progreso progreso, Usuario usuario);
    
    public void actualizarProgeso(Progreso progreso, Usuario usuario);
    
    public void eliminarProgeso(Progreso progreso, Usuario usuario);
}
