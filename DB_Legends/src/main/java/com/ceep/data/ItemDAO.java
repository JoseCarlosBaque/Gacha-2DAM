/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class ItemDAO implements IItemDAO {

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;

    @Override
    public List<Item> findAllItem() {
        return em.createNamedQuery("Item.findAll").getResultList();
    }

    @Override
    public Item findItemId(Item item) {
        return em.find(Item.class, item.getId_item());
    }

    @Override
    public void insertarItem(Item item) {
        em.persist(item);
    }

    @Override
    public void actualizarItem(Item item) {
        em.merge(item);
    }

    @Override
    public void borrarItem(Item item) {
        em.remove(em.merge(item));
    }

}
