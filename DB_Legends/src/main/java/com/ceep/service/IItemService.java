/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.item;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IItemService {
    public List<item> listar_items();
    
    public item findItemId(item item);
    
    public void insertarItem(item item);
    
    public void actualizarItem(item item);
    
    public void borrarItem(item item);
}
