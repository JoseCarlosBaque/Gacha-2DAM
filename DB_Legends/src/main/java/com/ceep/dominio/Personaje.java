/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Personaje.findAll", query = "SELECT p FROM personaje p"),
    @NamedQuery(name = "Personaje.findByName", query = "SELECT p FROM personaje p WHERE p.nombre LIKE :nombre")
//    @NamedQuery(name = "personaje.findByIdPersonaje", query = "SELECT p FROM personaje p WHERE p.id_Personaje = :id_Personaje"),
//    @NamedQuery(name = "personaje.findByNombre", query = "SELECT p FROM personaje p WHERE p.nombre = :nombre"),
//    @NamedQuery(name = "personaje.findByTitulo", query = "SELECT p FROM personaje p WHERE p.titulo = :titulo"),
//    @NamedQuery(name = "personaje.findByTipo", query = "SELECT p FROM personaje p WHERE p.tipo = :tipo"),
//    @NamedQuery(name = "personaje.findBySalud", query = "SELECT p FROM personaje p WHERE p.salud = :salud"),
//    @NamedQuery(name = "personaje.findByNivel", query = "SELECT p FROM personaje p WHERE p.nivel = :nivel"),
//    @NamedQuery(name = "personaje.findByDanioFisico", query = "SELECT p FROM personaje p WHERE p.danioFisico = :danioFisico"),
//    @NamedQuery(name = "personaje.findByDanioEnergia", query = "SELECT p FROM personaje p WHERE p.danioEnergia = :danioEnergia"),
//    @NamedQuery(name = "personaje.findByDefensaFisico", query = "SELECT p FROM personaje p WHERE p.defensaFisico = :defensaFisico"),
//    @NamedQuery(name = "personaje.findByDefensaEnergia", query = "SELECT p FROM personaje p WHERE p.defensaEnergia = :defensaEnergia"),
//    @NamedQuery(name = "personaje.findByCritico", query = "SELECT p FROM personaje p WHERE p.critico = :critico"),
//    @NamedQuery(name = "personaje.findBySoul", query = "SELECT p FROM personaje p WHERE p.soul = :soul"),
//    @NamedQuery(name = "personaje.findByEstrellas", query = "SELECT p FROM personaje p WHERE p.estrellas = :estrellas")
})
@Table(name = "personaje")
public class personaje implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personaje")
    private Integer idPersonaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salud")
    private int salud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "danio_fisico")
    private int danioFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "danio_energia")
    private int danioEnergia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defensa_fisico")
    private int defensaFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defensa_energia")
    private int defensaEnergia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "critico")
    private int critico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soul")
    private int soul;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estrellas")
    private int estrellas;
    @JoinTable(name = "personaje_banner", joinColumns = {
        @JoinColumn(name = "id_personaje", referencedColumnName = "id_personaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_banner", referencedColumnName = "id_banner")})
    @ManyToMany
    private Collection<banner> bannerCollection;
    @JoinColumn(name = "id_destreza", referencedColumnName = "id_destreza")
    @ManyToOne
    private destreza idDestreza;

    public personaje() {
    }

    public personaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public personaje(Integer idPersonaje, String nombre, String titulo, String tipo, int salud, int nivel, int danioFisico, int danioEnergia, int defensaFisico, int defensaEnergia, int critico, int soul, int estrellas) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.titulo = titulo;
        this.tipo = tipo;
        this.salud = salud;
        this.nivel = nivel;
        this.danioFisico = danioFisico;
        this.danioEnergia = danioEnergia;
        this.defensaFisico = defensaFisico;
        this.defensaEnergia = defensaEnergia;
        this.critico = critico;
        this.soul = soul;
        this.estrellas = estrellas;
    }

    public Integer getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDanioFisico() {
        return danioFisico;
    }

    public void setDanioFisico(int danioFisico) {
        this.danioFisico = danioFisico;
    }

    public int getDanioEnergia() {
        return danioEnergia;
    }

    public void setDanioEnergia(int danioEnergia) {
        this.danioEnergia = danioEnergia;
    }

    public int getDefensaFisico() {
        return defensaFisico;
    }

    public void setDefensaFisico(int defensaFisico) {
        this.defensaFisico = defensaFisico;
    }

    public int getDefensaEnergia() {
        return defensaEnergia;
    }

    public void setDefensaEnergia(int defensaEnergia) {
        this.defensaEnergia = defensaEnergia;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

    public int getSoul() {
        return soul;
    }

    public void setSoul(int soul) {
        this.soul = soul;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @XmlTransient
    public Collection<banner> getBannerCollection() {
        return bannerCollection;
    }

    public void setBannerCollection(Collection<banner> bannerCollection) {
        this.bannerCollection = bannerCollection;
    }

    public destreza getIdDestreza() {
        return idDestreza;
    }

    public void setIdDestreza(destreza idDestreza) {
        this.idDestreza = idDestreza;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idPersonaje);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.titulo);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + this.salud;
        hash = 23 * hash + this.nivel;
        hash = 23 * hash + this.danioFisico;
        hash = 23 * hash + this.danioEnergia;
        hash = 23 * hash + this.defensaFisico;
        hash = 23 * hash + this.defensaEnergia;
        hash = 23 * hash + this.critico;
        hash = 23 * hash + this.soul;
        hash = 23 * hash + this.estrellas;
        hash = 23 * hash + Objects.hashCode(this.bannerCollection);
        hash = 23 * hash + Objects.hashCode(this.idDestreza);
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
        final personaje other = (personaje) obj;
        if (this.salud != other.salud) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.danioFisico != other.danioFisico) {
            return false;
        }
        if (this.danioEnergia != other.danioEnergia) {
            return false;
        }
        if (this.defensaFisico != other.defensaFisico) {
            return false;
        }
        if (this.defensaEnergia != other.defensaEnergia) {
            return false;
        }
        if (this.critico != other.critico) {
            return false;
        }
        if (this.soul != other.soul) {
            return false;
        }
        if (this.estrellas != other.estrellas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.idPersonaje, other.idPersonaje)) {
            return false;
        }
        if (!Objects.equals(this.bannerCollection, other.bannerCollection)) {
            return false;
        }
        return Objects.equals(this.idDestreza, other.idDestreza);
    }

    @Override
    public String toString() {
        return "personaje{" + "idPersonaje=" + idPersonaje + ", nombre=" + nombre + ", titulo=" + titulo + ", tipo=" + tipo + ", salud=" + salud + ", nivel=" + nivel + ", danioFisico=" + danioFisico + ", danioEnergia=" + danioEnergia + ", defensaFisico=" + defensaFisico + ", defensaEnergia=" + defensaEnergia + ", critico=" + critico + ", soul=" + soul + ", estrellas=" + estrellas + ", bannerCollection=" + bannerCollection + ", idDestreza=" + idDestreza + '}';
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
