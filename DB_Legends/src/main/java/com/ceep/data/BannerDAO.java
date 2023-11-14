/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Banner;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class BannerDAO implements IBannerDAO{

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;
    
    @Override
    public List<Banner> findAllBanne() {
        return em.createNamedQuery("Banner.findAll").getResultList();
    }

    @Override
    public void insertarBanner(Banner banner) {
        em.persist(banner);
    }

    @Override
    public void borrarBanner(Banner banner) {
        em.remove(em.merge(banner));
    }
    
}
