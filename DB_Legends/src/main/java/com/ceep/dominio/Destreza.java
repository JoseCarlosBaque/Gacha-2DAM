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
    @NamedQuery(name = "Destreza.fineAll", query = "SELECT d FROM destreza d")
})
@Table(name = "destreza")
public class destreza implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_destreza")
    private Integer idDestreza;
    @Size(max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "danio")
    private int danio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multiplicador")
    private int multiplicador;
    @OneToMany(mappedBy = "idDestreza")
    private Collection<personaje> personajeCollection;

    public destreza() {
    }

    public destreza(Integer idDestreza) {
        this.idDestreza = idDestreza;
    }

    public destreza(int id_destreza, String tipo, int danio, int multiplicador) {
        this.idDestreza = id_destreza;
        this.tipo = tipo;
        this.danio = danio;
        this.multiplicador = multiplicador;
    }

    public Integer getIdDestreza() {
        return idDestreza;
    }

    public void setIdDestreza(Integer idDestreza) {
        this.idDestreza = idDestreza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @XmlTransient
    public Collection<personaje> getPersonajeCollection() {
        return personajeCollection;
    }

    public void setPersonajeCollection(Collection<personaje> personajeCollection) {
        this.personajeCollection = personajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idDestreza;
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
        final destreza other = (destreza) obj;
        if (this.idDestreza != other.idDestreza) {
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

    @Override
    public String toString() {
        return "destreza{" + "idDestreza=" + idDestreza + ", tipo=" + tipo + ", danio=" + danio + ", multiplicador=" + multiplicador + ", personajeCollection=" + personajeCollection + '}';
    }

    
}
