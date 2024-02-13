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
    @NamedQuery(name="Tienda.findAll", query="SELECT p FROM tienda p")
})
@Table(name="tienda")
public class tienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tienda")
    private Integer idTienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idTienda")
    private Collection<item> itemCollection;

    public tienda() {
    }

    public tienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public tienda(Integer idTienda, String nombre) {
        this.idTienda = idTienda;
        this.nombre = nombre;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idTienda);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.itemCollection);
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
        final tienda other = (tienda) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.idTienda, other.idTienda)) {
            return false;
        }
        return Objects.equals(this.itemCollection, other.itemCollection);
    }

    @Override
    public String toString() {
        return "tienda{" + "idTienda=" + idTienda + ", nombre=" + nombre + ", itemCollection=" + itemCollection + '}';
    }
}
