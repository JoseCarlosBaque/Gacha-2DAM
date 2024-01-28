/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.item;
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
    public List<item> findAllItem() {
        return em.createNamedQuery("Item.findAll").getResultList();
    }

    @Override
    public item findItemId(item item) {
        return em.find(item.class, item.getIdItem());
    }

    @Override
    public void insertarItem(item item) {
        em.persist(item);
    }

    @Override
    public void actualizarItem(item item) {
        em.merge(item);
    }

    @Override
    public void borrarItem(item item) {
        em.remove(em.merge(item));
    }

}
