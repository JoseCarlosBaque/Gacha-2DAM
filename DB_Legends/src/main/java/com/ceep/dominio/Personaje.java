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
    @NamedQuery(name="Personaje.fineAll", query="SELECT p FROM personaje p ORDER BY p.id_personaje")
})
@Table(name="personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personaje;
    private String nombre;
    private String titulo;
    private String tipo;
    private int salud;
    private int nivel;
    private int daño_fisico;
    private int daño_energia;
    private int defensa_fisica;
    private int defensa_enegia;
    private int critico;
    private int soul;
    private int estrellas;
    private boolean conseguido;

    public Personaje() {
    }

    public Personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Personaje(int id_personaje, String nombre, String titulo, String tipo, int salud, int nivel, int daño_fisico, int daño_energia, int defensa_fisica, int defensa_enegia, int critico, int soul, int estrellas, boolean conseguido) {
        this.id_personaje = id_personaje;
        this.nombre = nombre;
        this.titulo = titulo;
        this.tipo = tipo;
        this.salud = salud;
        this.nivel = nivel;
        this.daño_fisico = daño_fisico;
        this.daño_energia = daño_energia;
        this.defensa_fisica = defensa_fisica;
        this.defensa_enegia = defensa_enegia;
        this.critico = critico;
        this.soul = soul;
        this.estrellas = estrellas;
        this.conseguido = conseguido;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
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

    public int getDaño_fisico() {
        return daño_fisico;
    }

    public void setDaño_fisico(int daño_fisico) {
        this.daño_fisico = daño_fisico;
    }

    public int getDaño_energia() {
        return daño_energia;
    }

    public void setDaño_energia(int daño_energia) {
        this.daño_energia = daño_energia;
    }

    public int getDefensa_fisica() {
        return defensa_fisica;
    }

    public void setDefensa_fisica(int defensa_fisica) {
        this.defensa_fisica = defensa_fisica;
    }

    public int getDefensa_enegia() {
        return defensa_enegia;
    }

    public void setDefensa_enegia(int defensa_enegia) {
        this.defensa_enegia = defensa_enegia;
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

    public boolean isConseguido() {
        return conseguido;
    }

    public void setConseguido(boolean conseguido) {
        this.conseguido = conseguido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_personaje;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + Objects.hashCode(this.tipo);
        hash = 31 * hash + this.salud;
        hash = 31 * hash + this.nivel;
        hash = 31 * hash + this.daño_fisico;
        hash = 31 * hash + this.daño_energia;
        hash = 31 * hash + this.defensa_fisica;
        hash = 31 * hash + this.defensa_enegia;
        hash = 31 * hash + this.critico;
        hash = 31 * hash + this.soul;
        hash = 31 * hash + this.estrellas;
        hash = 31 * hash + (this.conseguido ? 1 : 0);
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
        final Personaje other = (Personaje) obj;
        if (this.id_personaje != other.id_personaje) {
            return false;
        }
        if (this.salud != other.salud) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.daño_fisico != other.daño_fisico) {
            return false;
        }
        if (this.daño_energia != other.daño_energia) {
            return false;
        }
        if (this.defensa_fisica != other.defensa_fisica) {
            return false;
        }
        if (this.defensa_enegia != other.defensa_enegia) {
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
        if (this.conseguido != other.conseguido) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
}
