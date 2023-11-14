/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Item;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IItemDAO {
    public List<Item> findAllItem();
    
    public Item findItemId(Item item);
    
    public void insertarItem(Item item);
    
    public void actualizarItem(Item item);
    
    public void borrarItem(Item item);
}
