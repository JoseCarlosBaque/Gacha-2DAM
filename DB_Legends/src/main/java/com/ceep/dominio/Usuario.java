/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Usuario.fineAll", query="SELECT p FROM usuario p ORDER BY p.id_usuario")
})
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String usuario;
    private String clave;
    private int nivel;

    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String usuario, String clave, int nivel) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }

    public Usuario(String usuario, String clave, int nivel) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_usuario;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.clave);
        hash = 97 * hash + this.nivel;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }
}
