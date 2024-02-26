/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.personaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author joseb
 */
@Stateless
public class PersonajeDAO implements IPersonajeDAO {

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;

    @Override
    public List<personaje> findAllPersonaje() {
        return em.createNamedQuery("Personaje.findAll").getResultList();
    }

    @Override
    public personaje findPersonajeId(personaje personaje) {
        return em.find(personaje.class, personaje.getIdPersonaje());
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

    @Override
    public List<personaje> findPersonajeName(String nombre) {
        try {
            TypedQuery<personaje> query = em.createNamedQuery("Personaje.findByName", personaje.class);
            query.setParameter("nombre", "%" + nombre + "%"); // Utilizamos % para hacer una búsqueda que coincida parcialmente con el nombre
            return query.getResultList();
        } catch (NoResultException e) {
            return null; // Manejo de caso en que no se encuentre ningún resultado
        }
    }

}
