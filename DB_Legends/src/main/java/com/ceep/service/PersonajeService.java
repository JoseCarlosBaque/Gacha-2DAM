/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IPersonajeDAO;
import com.ceep.dominio.personaje;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class PersonajeService implements IPersonajeService{

    @Inject
    IPersonajeDAO personajeDao;
    
    @Override
    public List<personaje> listarPersonajes() {
        return personajeDao.findAllPersonaje();
    }

    @Override
    public personaje findPersonajeId(personaje personaje) {
        return personajeDao.findPersonajeId(personaje);
    }

    @Override
    public void insertarPersonaje(personaje personaje) {
        personajeDao.insertarPersonaje(personaje);
    }

    @Override
    public void actualizarPersonaje(personaje personaje) {
        personajeDao.actualizarPersonaje(personaje);
    }

    @Override
    public void borrarPersonaje(personaje personaje) {
        personajeDao.borrarPersonaje(personaje);
    }
    
}
