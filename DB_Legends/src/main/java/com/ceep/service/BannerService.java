/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IBannerDAO;
import com.ceep.dominio.banner;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class BannerService implements IBannerService{

    @Inject
    IBannerDAO bannerDAO;
    
    @Override
    public List<banner> listarBanner() {
        return bannerDAO.findAllBanner();
    }
    
    @Override
    public void insertarBanner(banner banner) {
        bannerDAO.insertarBanner(banner);
    }

    @Override
    public void borrarBanner(banner banner) {
        bannerDAO.borrarBanner(banner);
    }

    @Override
    public void insertarLista(Byte[] lista) {
        bannerDAO.insertarLista(lista);
    }

    @Override
    public void actualizarBanner(banner banner) {
        bannerDAO.actualizarBanner(banner);
    }
    
}
