/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.personaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class PersonajeDAO implements IPersonajeDAO{

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;
    
    @Override
    public List<personaje> findAllPersonaje() {
        return em.createNamedQuery("Personaje.findAll").getResultList();
    }

    @Override
    public personaje findPersonajeId(personaje personaje) {
        return em.find(personaje.class, personaje.getId_personaje());
    }

    @Override
    public void insertarPersonaje(personaje personaje) {
        em.persist(personaje);
    }

    @Override
    public void actualizarPersonaje(personaje personaje) {
     em.merge(personaje);
    }

    @Override
    public void borrarPersonaje(personaje personaje) {
        em.remove(em.merge(personaje));
    }

    
    
}
