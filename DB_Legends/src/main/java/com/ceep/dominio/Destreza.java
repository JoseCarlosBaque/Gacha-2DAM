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
    @NamedQuery(name="Destreza.fineAll", query="SELECT p FROM destreza p ORDER BY p.id_destreza")
})
@Table(name="destreza")
public class Destreza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_destreza;
    private String tipo;
    private int danio;
    private int multiplicador;

    public Destreza(int id_destreza, String tipo, int danio, int multiplicador) {
        this.id_destreza = id_destreza;
        this.tipo = tipo;
        this.danio = danio;
        this.multiplicador = multiplicador;
    }

    public int getId_destreza() {
        return id_destreza;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDanio() {
        return danio;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_destreza;
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + this.danio;
        hash = 89 * hash + this.multiplicador;
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
        final Destreza other = (Destreza) obj;
        if (this.id_destreza != other.id_destreza) {
            return false;
        }
        if (this.danio != other.danio) {
            return false;
        }
        if (this.multiplicador != other.multiplicador) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
}
