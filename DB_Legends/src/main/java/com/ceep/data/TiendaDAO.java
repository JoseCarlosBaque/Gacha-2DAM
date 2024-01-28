/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.tienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class TiendaDAO implements ITiendaDAO {

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;

    @Override
    public List<tienda> findAllTienda() {
        return em.createNamedQuery("Tienda.findAll").getResultList();
    }

    @Override
    public tienda findTiendaId(tienda tienda) {
        return em.find(tienda.class, tienda.getIdTienda());
    }

}
