/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joseb
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO {

    @PersistenceContext(unitName = "DBL_PU")
    EntityManager em;

    @Override
    public List<usuario> findAllUsuario() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public usuario findUsuarioId(usuario usuario) {
        return em.find(usuario.class, usuario.getId_usuario());
    }

    @Override
    public void insertarUsuario(usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizarUsuario(usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void borrarUsuario(usuario usuario) {
        em.remove(em.merge(usuario));
    }

}
