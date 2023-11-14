/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Tienda;
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
    public List<Tienda> findAllTienda() {
        return em.createNamedQuery("Tienda.findAll").getResultList();
    }

    @Override
    public Tienda findTiendaId(Tienda tienda) {
        return em.find(Tienda.class, tienda.getId_tienda());
    }

}
