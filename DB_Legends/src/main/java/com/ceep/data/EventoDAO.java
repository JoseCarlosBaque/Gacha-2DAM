/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.evento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class EventoDAO implements IEventoDAO{

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;
    
    @Override
    public List<evento> findAllEvento() {
        return em.createNamedQuery("Evento.findAll").getResultList();
    }

    @Override
    public evento findEventoId(evento evento) {
        return em.find(evento.class, evento.getIdEvento());
    }

    @Override
    public void insertarEvento(evento evento) {
        em.persist(evento);
    }

    @Override
    public void actualizarEvento(evento evento) {
        em.merge(evento);
    }

    @Override
    public void borrarEvento(evento evento) {
        em.remove(em.merge(evento));
    }
    
}
