/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.tienda;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface ITiendaService {
    public List<tienda> findAllTienda();
    public tienda findTiendaId(tienda tienda);
}
