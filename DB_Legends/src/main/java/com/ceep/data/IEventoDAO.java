/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Evento;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IEventoDAO {
    public List<Evento> findAllEvento();
    
    public Evento findEventoId(Evento evento);
    
    public void insertarEvento(Evento evento);
    
    public void actualizarEvento(Evento evento);
    
    public void borrarEvento(Evento evento);
}
