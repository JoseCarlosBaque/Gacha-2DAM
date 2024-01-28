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
    @NamedQuery(name="Item.fineAll", query="SELECT p FROM item p")
})
@Table(name="item")
public class item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 20)
    @Column(name = "tipo")
    private String tipo;
    @JoinTable(name = "item_banner", joinColumns = {
        @JoinColumn(name = "id_item", referencedColumnName = "id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "id_banner", referencedColumnName = "id_banner")})
    @ManyToMany
    private Collection<banner> bannerCollection;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne
    private tienda idTienda;

    public item() {
    }

    public item(Integer idItem) {
        this.idItem = idItem;
    }

    public item(Integer idItem, String nombre, int cantidad) {
        this.idItem = idItem;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<banner> getBannerCollection() {
        return bannerCollection;
    }

    public void setBannerCollection(Collection<banner> bannerCollection) {
        this.bannerCollection = bannerCollection;
    }

    public tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(tienda idTienda) {
        this.idTienda = idTienda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idItem);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.bannerCollection);
        hash = 97 * hash + Objects.hashCode(this.idTienda);
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
        final item other = (item) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.idItem, other.idItem)) {
            return false;
        }
        if (!Objects.equals(this.bannerCollection, other.bannerCollection)) {
            return false;
        }
        return Objects.equals(this.idTienda, other.idTienda);
    }

    @Override
    public String toString() {
        return "item{" + "idItem=" + idItem + ", nombre=" + nombre + ", cantidad=" + cantidad + ", tipo=" + tipo + ", bannerCollection=" + bannerCollection + ", idTienda=" + idTienda + '}';
    }
}
