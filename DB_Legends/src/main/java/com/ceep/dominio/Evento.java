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
import javax.persistence.Table;

/**
 *
 * @author joseb
 */
@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;
    private int id_progreso;
    private String nombre;
    private int niveles;

    public Evento() {
    }

    public Evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public Evento(int id_evento, int id_progreso) {
        this.id_evento = id_evento;
        this.id_progreso = id_progreso;
    }

    public Evento(int id_evento, int id_progreso, String nombre, int niveles) {
        this.id_evento = id_evento;
        this.id_progreso = id_progreso;
        this.nombre = nombre;
        this.niveles = niveles;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_progreso() {
        return id_progreso;
    }

    public void setId_progreso(int id_progreso) {
        this.id_progreso = id_progreso;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_evento;
        hash = 17 * hash + this.id_progreso;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + this.niveles;
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
        final Evento other = (Evento) obj;
        if (this.id_evento != other.id_evento) {
            return false;
        }
        if (this.id_progreso != other.id_progreso) {
            return false;
        }
        if (this.niveles != other.niveles) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
}
