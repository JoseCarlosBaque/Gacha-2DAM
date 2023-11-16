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
    @NamedQuery(name="Item.fineAll", query="SELECT p FROM item p ORDER BY p.id_item")
})
@Table(name="item")
public class item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_item;
    private String nombre;
    private int cantidad;
    private String tipo;
    private int id_tienda;
    private boolean stock;

    public item() {
    }

    public item(int id_item) {
        this.id_item = id_item;
    }

    public item(int id_item, String nombre, int cantidad, String tipo, int id_tienda, boolean stock) {
        this.id_item = id_item;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.id_tienda = id_tienda;
        this.stock = stock;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
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

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_item;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + this.cantidad;
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + this.id_tienda;
        hash = 47 * hash + (this.stock ? 1 : 0);
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
        if (this.id_item != other.id_item) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.id_tienda != other.id_tienda) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
}
