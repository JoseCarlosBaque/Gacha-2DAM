/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.evento;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IEventoService {
    public List<evento> findAllEvento();
    
    public evento findEventoId(evento evento);
    
    public void insertarEvento(evento evento);
    
    public void actualizarEvento(evento evento);
    
    public void borrarEvento(evento evento);
}
