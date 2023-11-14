/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Personaje;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IPersonajeDAO {
    public List<Personaje> findAllPersonaje();
    
    public Personaje findPersonajeId(Personaje personaje);
    
    public void insertarPersonaje(Personaje personaje);
    
    public void actualizarPersonaje(Personaje personaje);
    
    public void borrarPersonaje(Personaje personaje);
}
