/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Usuario.findAll", query="SELECT p FROM usuario p"), //ORDER BY p.id_usuario iba pero des pues de importar la clase ya no va
    @NamedQuery(name="Usuario.login", query="SELECT p FROM usuario p WHERE p.usuario = :usuario AND p.clave = :clave")
})
@Table(name="usuario")
public class usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "clave")
    private String clave;
    @Column(name = "nivel")
    private Integer nivel;
    @Size(max = 125)
    @Column(name = "lista_personajes")
    private String listaPersonajes;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<progreso> progresoCollection;
    private static final long SerialVersionUID = 1L;

    public usuario() {
    }

    public usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public usuario(Integer idUsuario, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public usuario(String usuario, String clave, Integer nivel) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }

    public usuario(String usuario, String clave, Integer nivel, String listaPersonajes, Collection<progreso> progresoCollection) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.listaPersonajes = listaPersonajes;
        this.progresoCollection = progresoCollection;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(String listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @XmlTransient
    public Collection<progreso> getProgresoCollection() {
        return progresoCollection;
    }

    public void setProgresoCollection(Collection<progreso> progresoCollection) {
        this.progresoCollection = progresoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idUsuario);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.clave);
        hash = 97 * hash + Objects.hashCode(this.nivel);
        hash = 97 * hash + Objects.hashCode(this.listaPersonajes);
        hash = 97 * hash + Objects.hashCode(this.progresoCollection);
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
        final usuario other = (usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.listaPersonajes, other.listaPersonajes)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return Objects.equals(this.progresoCollection, other.progresoCollection);
    }

    @Override
    public String toString() {
        return "usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", nivel=" + nivel + ", listaPersonajes=" + listaPersonajes + ", progresoCollection=" + progresoCollection + '}';
    }
}
