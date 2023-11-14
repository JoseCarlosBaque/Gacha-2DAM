/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Personaje;
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
    public List<Personaje> findAllPersonaje() {
        return em.createNamedQuery("Personaje.findAll").getResultList();
    }

    @Override
    public Personaje findPersonajeId(Personaje personaje) {
        return em.find(Personaje.class, personaje.getId_personaje());
    }

    @Override
    public void insertarPersonaje(Personaje personaje) {
        em.persist(personaje);
    }

    @Override
    public void actualizarPersonaje(Personaje personaje) {
     em.merge(personaje);
    }

    @Override
    public void borrarPersonaje(Personaje personaje) {
        em.remove(em.merge(personaje));
    }

    
    
}
