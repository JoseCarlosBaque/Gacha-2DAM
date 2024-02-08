/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.service;

import com.ceep.data.IDestrezaDAO;
import com.ceep.dominio.destreza;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author joseb
 */
public class DestrezaService implements IDestrezaService{

    @Inject
    IDestrezaDAO destrezaDAO;
    
    @Override
    public List<destreza> findAllDestreza() {
        return destrezaDAO.findAllDestreza();
    }
    
}
