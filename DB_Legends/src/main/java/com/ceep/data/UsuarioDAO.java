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
import javax.transaction.Transactional;

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
        return em.find(usuario.class, usuario.getIdUsuario());
    }
    
    @Override
    public usuario findUsuario(String nombre, String clave) {
        usuario user = (usuario) em.createNamedQuery("Usuario.login")
                .setParameter("usuario", nombre)
                .setParameter("clave", clave)
                .getSingleResult();
        return user;
    }

    @Override
    public void insertarUsuario(usuario usuario) {
        em.persist(usuario);
    }

    @Transactional
    @Override
    public void updateUser(usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void borrarUsuario(usuario usuario) {
        em.remove(em.merge(usuario));
    }

}
