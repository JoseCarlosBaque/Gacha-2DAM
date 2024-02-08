/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.service;

import com.ceep.dominio.banner;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IBannerService {
    public List<banner> listarBanner();
    
    public void insertarBanner(banner banner);
    
    public void actualizarBanner(banner banner);
    
    public void insertarLista(Byte[] lista);
    
    public void borrarBanner(banner banner);
}
