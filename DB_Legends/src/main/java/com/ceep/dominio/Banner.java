/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Banner.fineAll", query="SELECT p FROM banner p ORDER BY p.id_banner")
})
@Table(name="banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_banner;
    private String nombre;
    private int precio;
    private int step;
    private int prob_nuevo;
    private int prob_sp;
    private int prob_ex;
    private int prob_hero;

    public Banner() {
    }

    public Banner(int id_banner) {
        this.id_banner = id_banner;
    }

    public Banner(int id_banner, String nombre, int precio, int step, int prob_nuevo, int prob_sp, int prob_ex, int prob_hero) {
        this.id_banner = id_banner;
        this.nombre = nombre;
        this.precio = precio;
        this.step = step;
        this.prob_nuevo = prob_nuevo;
        this.prob_sp = prob_sp;
        this.prob_ex = prob_ex;
        this.prob_hero = prob_hero;
    }

    public int getId_banner() {
        return id_banner;
    }

    public void setId_banner(int id_banner) {
        this.id_banner = id_banner;
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

    public int getProb_nuevo() {
        return prob_nuevo;
    }

    public void setProb_nuevo(int prob_nuevo) {
        this.prob_nuevo = prob_nuevo;
    }

    public int getProb_sp() {
        return prob_sp;
    }

    public void setProb_sp(int prob_sp) {
        this.prob_sp = prob_sp;
    }

    public int getProb_ex() {
        return prob_ex;
    }

    public void setProb_ex(int prob_ex) {
        this.prob_ex = prob_ex;
    }

    public int getProb_hero() {
        return prob_hero;
    }

    public void setProb_hero(int prob_hero) {
        this.prob_hero = prob_hero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_banner;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + this.precio;
        hash = 37 * hash + this.step;
        hash = 37 * hash + this.prob_nuevo;
        hash = 37 * hash + this.prob_sp;
        hash = 37 * hash + this.prob_ex;
        hash = 37 * hash + this.prob_hero;
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
        final Banner other = (Banner) obj;
        if (this.id_banner != other.id_banner) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (this.step != other.step) {
            return false;
        }
        if (this.prob_nuevo != other.prob_nuevo) {
            return false;
        }
        if (this.prob_sp != other.prob_sp) {
            return false;
        }
        if (this.prob_ex != other.prob_ex) {
            return false;
        }
        if (this.prob_hero != other.prob_hero) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
}
