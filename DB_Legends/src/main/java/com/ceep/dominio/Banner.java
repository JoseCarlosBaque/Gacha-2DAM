/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Banner.findAll", query = "SELECT p FROM banner p") //ORDER BY p.id_banner no va xd
})
@Table(name = "banner")
public class banner implements Serializable {

    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "step")
    private int step;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prob_nuevo")
    private int probNuevo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prob_sp")
    private int probSp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prob_ex")
    private int probEx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prob_hero")
    private int probHero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lista")
    private byte[] lista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "foto")
    private String foto;
    @ManyToMany(mappedBy = "bannerCollection")
    private Collection<item> itemCollection;
    @ManyToMany(mappedBy = "bannerCollection")
    private Collection<personaje> personajeCollection;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banner")
    private int idBanner;

    public banner() {
    }

    public banner(int id_banner) {
        this.idBanner = id_banner;
    }

    public banner(Integer idBanner, int precio, int step, int probNuevo, int probSp, int probEx, int probHero, String descripcion) {
        this.idBanner = idBanner;
        this.precio = precio;
        this.step = step;
        this.probNuevo = probNuevo;
        this.probSp = probSp;
        this.probEx = probEx;
        this.probHero = probHero;
        this.descripcion = descripcion;
    }

    public banner(String nombre, int precio, int step, int probNuevo, int probSp, int probEx, int probHero, String descripcion, byte[] lista, String foto, int idBanner) {
        this.nombre = nombre;
        this.precio = precio;
        this.step = step;
        this.probNuevo = probNuevo;
        this.probSp = probSp;
        this.probEx = probEx;
        this.probHero = probHero;
        this.descripcion = descripcion;
        this.lista = lista;
        this.foto = foto;
        this.idBanner = idBanner;
    }

    public banner(String nombre, int precio, int step, int probNuevo, int probSp, int probEx, int probHero, String descripcion, byte[] lista, String foto, Collection<item> itemCollection, Collection<personaje> personajeCollection, int idBanner) {
        this.nombre = nombre;
        this.precio = precio;
        this.step = step;
        this.probNuevo = probNuevo;
        this.probSp = probSp;
        this.probEx = probEx;
        this.probHero = probHero;
        this.descripcion = descripcion;
        this.lista = lista;
        this.foto = foto;
        this.itemCollection = itemCollection;
        this.personajeCollection = personajeCollection;
        this.idBanner = idBanner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getProbNuevo() {
        return probNuevo;
    }

    public void setProbNuevo(int probNuevo) {
        this.probNuevo = probNuevo;
    }

    public int getProbSp() {
        return probSp;
    }

    public void setProbSp(int probSp) {
        this.probSp = probSp;
    }

    public int getProbEx() {
        return probEx;
    }

    public void setProbEx(int probEx) {
        this.probEx = probEx;
    }

    public int getProbHero() {
        return probHero;
    }

    public void setProbHero(int probHero) {
        this.probHero = probHero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getLista() {
        return lista;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setLista(byte[] lista) {
        this.lista = lista;
    }

    public int getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(int idBanner) {
        this.idBanner = idBanner;
    }

    @XmlTransient
    public Collection<item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<personaje> getPersonajeCollection() {
        return personajeCollection;
    }

    public void setPersonajeCollection(Collection<personaje> personajeCollection) {
        this.personajeCollection = personajeCollection;
    }

    public List<personaje> deserializar(byte[] cod) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(cod);
        ObjectInput in = new ObjectInputStream(bis);
        List<personaje> lista_banner = (List<personaje>) in.readObject();
        return lista_banner;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idBanner;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + this.precio;
        hash = 37 * hash + this.step;
        hash = 37 * hash + this.probNuevo;
        hash = 37 * hash + this.probSp;
        hash = 37 * hash + this.probEx;
        hash = 37 * hash + this.probHero;
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
        final banner other = (banner) obj;
        if (!Objects.equals(this.idBanner, other.idBanner)) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (this.step != other.step) {
            return false;
        }
        if (this.probNuevo != other.probNuevo) {
            return false;
        }
        if (this.probSp != other.probSp) {
            return false;
        }
        if (this.probEx != other.probEx) {
            return false;
        }
        if (this.probHero != other.probHero) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "banner{" + "idBanner=" + idBanner + ", nombre=" + nombre + ", precio=" + precio + ", step=" + step + ", probNuevo=" + probNuevo + ", probSp=" + probSp + ", probEx=" + probEx + ", probHero=" + probHero + ", descripcion=" + descripcion + '}';
    }
}
