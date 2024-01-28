/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Progreso.fineAll", query="SELECT p FROM progreso p")
})
@Table(name="progreso")
public class progreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_progreso")
    private Integer idProgreso;
    @Column(name = "experiencia")
    private Integer experiencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha;
    @OneToMany(mappedBy = "idProgreso")
    private Collection<evento> eventoCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private usuario idUsuario;

    public progreso() {
    }

    public progreso(Integer idProgreso) {
        this.idProgreso = idProgreso;
    }

    public progreso(Integer idProgreso, Integer experiencia, java.util.Date fecha, Collection<evento> eventoCollection, usuario idUsuario) {
        this.idProgreso = idProgreso;
        this.experiencia = experiencia;
        this.fecha = fecha;
        this.eventoCollection = eventoCollection;
        this.idUsuario = idUsuario;
    }

    public Integer getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Integer idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idProgreso);
        hash = 29 * hash + Objects.hashCode(this.experiencia);
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.eventoCollection);
        hash = 29 * hash + Objects.hashCode(this.idUsuario);
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
        final progreso other = (progreso) obj;
        if (!Objects.equals(this.idProgreso, other.idProgreso)) {
            return false;
        }
        if (!Objects.equals(this.experiencia, other.experiencia)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.eventoCollection, other.eventoCollection)) {
            return false;
        }
        return Objects.equals(this.idUsuario, other.idUsuario);
    }

    @Override
    public String toString() {
        return "progreso{" + "idProgreso=" + idProgreso + ", experiencia=" + experiencia + ", fecha=" + fecha + ", eventoCollection=" + eventoCollection + ", idUsuario=" + idUsuario + '}';
    }
}
