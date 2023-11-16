/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author joseb
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Progreso.fineAll", query="SELECT p FROM progreso p ORDER BY p.id_progreso")
})
@Table(name="progreso")
public class progreso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_progreso;
    private int id_usuario;
    private int experiencia;
    private Date fecha;

    public progreso() {
    }

    public progreso(int id_progreso) {
        this.id_progreso = id_progreso;
    }

    public progreso(int id_progreso, int id_usuario, int experiencia, Date fecha) {
        this.id_progreso = id_progreso;
        this.id_usuario = id_usuario;
        this.experiencia = experiencia;
        this.fecha = fecha;
    }

    public int getId_progreso() {
        return id_progreso;
    }

    public void setId_progreso(int id_progreso) {
        this.id_progreso = id_progreso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_progreso;
        hash = 59 * hash + this.id_usuario;
        hash = 59 * hash + this.experiencia;
        hash = 59 * hash + Objects.hashCode(this.fecha);
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
        if (this.id_progreso != other.id_progreso) {
            return false;
        }
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        if (this.experiencia != other.experiencia) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
}
