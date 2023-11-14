/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Banner;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface IBannerDAO {
    public List<Banner> findAllBanne();
    
    public void insertarBanner(Banner banner);
    
    public void borrarBanner(Banner banner);
}
