/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.personaje;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IPersonajeService {
    public List<personaje> findAllPersonaje();
    
    public personaje findPersonajeId(personaje personaje);
    
    public void insertarPersonaje(personaje personaje);
    
    public void actualizarPersonaje(personaje personaje);
    
    public void borrarPersonaje(personaje personaje);
}
