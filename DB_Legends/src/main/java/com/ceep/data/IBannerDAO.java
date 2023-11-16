/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.banner;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IBannerDAO {
    public List<banner> findAllBanne();
    
    public void insertarBanner(banner banner);
    
    public void borrarBanner(banner banner);
}
