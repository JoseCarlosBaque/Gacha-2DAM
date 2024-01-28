/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Evento.fineAll", query="SELECT p FROM evento p")
})
@Table(name="evento")
public class evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveles")
    private int niveles;
    @JoinColumn(name = "id_progreso", referencedColumnName = "id_progreso")
    @ManyToOne
    private progreso idProgreso;

    public evento() {
    }


    public evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public evento(Integer idEvento, String nombre, int niveles) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.niveles = niveles;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public progreso getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(progreso idProgreso) {
        this.idProgreso = idProgreso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idEvento);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + this.niveles;
        hash = 79 * hash + Objects.hashCode(this.idProgreso);
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
        final evento other = (evento) obj;
        if (this.niveles != other.niveles) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.idEvento, other.idEvento)) {
            return false;
        }
        return Objects.equals(this.idProgreso, other.idProgreso);
    }

    @Override
    public String toString() {
        return "evento{" + "idEvento=" + idEvento + ", nombre=" + nombre + ", niveles=" + niveles + ", idProgreso=" + idProgreso + '}';
    }

    
}
