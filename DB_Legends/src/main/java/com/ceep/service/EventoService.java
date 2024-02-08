/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IEventoDAO;
import com.ceep.dominio.evento;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class EventoService implements IEventoService {

    @Inject
    IEventoDAO eventoDAO;

    @Override
    public List<evento> findAllEvento() {
        return eventoDAO.findAllEvento();
    }

    @Override
    public evento findEventoId(evento evento) {
        return eventoDAO.findEventoId(evento);
    }

    @Override
    public void insertarEvento(evento evento) {
        eventoDAO.insertarEvento(evento);
    }

    @Override
    public void actualizarEvento(evento evento) {
        eventoDAO.actualizarEvento(evento);
    }

    @Override
    public void borrarEvento(evento evento) {
        eventoDAO.borrarEvento(evento);
    }

}
