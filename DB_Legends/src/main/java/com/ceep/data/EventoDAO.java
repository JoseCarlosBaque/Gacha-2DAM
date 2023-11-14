/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Evento;
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
    public List<Evento> findAllEvento() {
        return em.createNamedQuery("Evento.findAll").getResultList();
    }

    @Override
    public Evento findEventoId(Evento evento) {
        return em.find(Evento.class, evento.getId_evento());
    }

    @Override
    public void insertarEvento(Evento evento) {
        em.persist(evento);
    }

    @Override
    public void actualizarEvento(Evento evento) {
        em.merge(evento);
    }

    @Override
    public void borrarEvento(Evento evento) {
        em.remove(em.merge(evento));
    }
    
}
