/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.ITiendaDAO;
import com.ceep.dominio.tienda;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class TiendaService implements ITiendaService {

    @Inject
    ITiendaDAO tiendaDAO;
    
    @Override
    public List<tienda> findAllTienda() {
        return tiendaDAO.findAllTienda();
    }

    @Override
    public tienda findTiendaId(tienda tienda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
