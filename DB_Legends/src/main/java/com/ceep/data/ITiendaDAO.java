/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Tienda;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface ITiendaDAO {
    public List<Tienda> findAllTienda();
    public Tienda findTiendaId(Tienda tienda);
}
