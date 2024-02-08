/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IItemDAO;
import com.ceep.dominio.item;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class ItemService implements IItemService {

    @Inject
    IItemDAO itemdao;

    @Override
    public List<item> listar_items() {
        return itemdao.findAllItem();
    }

    @Override
    public item findItemId(item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarItem(item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarItem(item item) {
        itemdao.actualizarItem(item);
    }

    @Override
    public void borrarItem(item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
