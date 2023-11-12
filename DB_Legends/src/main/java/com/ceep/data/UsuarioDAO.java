/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.data;

import com.ceep.dominio.Usuario;
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
    public List<Usuario> findAllUsuario() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioId(Usuario usuario) {
        return em.find(Usuario.class, usuario.getId_usuario());
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

}
