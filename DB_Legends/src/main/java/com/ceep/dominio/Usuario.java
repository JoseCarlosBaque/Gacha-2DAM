/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.dominio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM usuario p"), //ORDER BY p.id_usuario iba pero des pues de importar la clase ya no va
    @NamedQuery(name = "Usuario.login", query = "SELECT p FROM usuario p WHERE p.usuario = :usuario AND p.clave = :clave")
})
@Table(name = "usuario")
public class usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "clave")
    private String clave;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "experiencia")
    private Integer experiencia;
    @Column(name = "lista_personajes")
    private byte[] listaPersonajes;
    @Column(name = "lista_items")
    private byte[] listaItems;
    @Column(name = "lista_equipos")
    private byte[] listaEquipos;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<progreso> progresoCollection;
    private static final long SerialVersionUID = 1L;

    public usuario() {
    }

    public usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public usuario(Integer idUsuario, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public usuario(String usuario, String clave, Integer nivel) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }

    public usuario(String usuario, String clave, Integer nivel, Integer experiecia, byte[] listaPersonajes, byte[] listaItems) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.experiencia = experiecia;
        this.listaPersonajes = listaPersonajes;
        this.listaItems = listaItems;
    }

    public usuario(Integer idUsuario, String usuario, String clave, Integer nivel, Integer experiecia, byte[] listaPersonajes, byte[] listaItems) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.experiencia = experiecia;
        this.listaPersonajes = listaPersonajes;
        this.listaItems = listaItems;
    }

    public usuario(Integer idUsuario, String usuario, String clave, Integer nivel, Integer experiencia, byte[] listaPersonajes, byte[] listaItems, byte[] listaEquipos) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.listaPersonajes = listaPersonajes;
        this.listaItems = listaItems;
        this.listaEquipos = listaEquipos;
    }

    public usuario(Integer idUsuario, String usuario, String clave, Integer nivel, byte[] listaPersonajes, byte[] listaItems, Collection<progreso> progresoCollection) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.listaPersonajes = listaPersonajes;
        this.listaItems = listaItems;
        this.progresoCollection = progresoCollection;
    }

    public usuario(Integer idUsuario, String usuario, String clave, Integer nivel, Integer experiencia, byte[] listaPersonajes, byte[] listaItems, byte[] listaEquipos, Collection<progreso> progresoCollection) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.listaPersonajes = listaPersonajes;
        this.listaItems = listaItems;
        this.listaEquipos = listaEquipos;
        this.progresoCollection = progresoCollection;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public byte[] getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(byte[] listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    public byte[] getListaItems() {
        return listaItems;
    }

    public void setListaItems(byte[] listaItems) {
        this.listaItems = listaItems;
    }

    @XmlTransient
    public Collection<progreso> getProgresoCollection() {
        return progresoCollection;
    }

    public void setProgresoCollection(Collection<progreso> progresoCollection) {
        this.progresoCollection = progresoCollection;
    }

    public byte[] getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(byte[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    //Deserializamos El Array De los Personajes Del usuario
    public List<personaje> deserializar_pjs(byte[] cod) throws ClassNotFoundException, IOException {
        List<personaje> lista_banner = null;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(cod); ObjectInput in = new ObjectInputStream(bis)) {
            lista_banner = (List<personaje>) in.readObject();
            System.out.println("Deserialización exitosa. Número de personajes: " + lista_banner.size());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error durante la deserialización: " + e.getMessage());
            e.printStackTrace();
        }
        return lista_banner;
    }

    //Serializamos El Array De los Personajes Del usuario
    public byte[] serializar_pjs(List<personaje> lista) throws ClassNotFoundException, IOException {
        byte[] serializedArray = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(lista);
            serializedArray = bos.toByteArray();
            System.out.println("Serialización exitosa. Tamaño del array: " + serializedArray.length + " bytes");
        } catch (IOException e) {
            System.err.println("Error durante la serialización: " + e.getMessage());
            e.printStackTrace();
        }
        return serializedArray;
    }

    //Deserializamos El Array De los Items Del usuario
    public List<item> deserializar_items(byte[] cod) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(cod);
        ObjectInput in = new ObjectInputStream(bis);
        List<item> lista_items = (List<item>) in.readObject();
        return lista_items;
    }
    
    //Serializamos El Array De los Items Del usuario
    public byte[] serializar_items(List<item> lista) throws ClassNotFoundException, IOException {
        byte[] serializedArray = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(lista);
            serializedArray = bos.toByteArray();
            System.out.println("Serialización exitosa. Tamaño del array: " + serializedArray.length + " bytes");
        } catch (IOException e) {
            System.err.println("Error durante la serialización: " + e.getMessage());
            e.printStackTrace();
        }
        return serializedArray;
    }

    //Deserializamos El Array De los equipos Del usuario
    public List<byte[]> deserializar_equipos(byte[] cod) throws ClassNotFoundException, IOException {
        List<byte[]> lista_equipos = null;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(cod); ObjectInput in = new ObjectInputStream(bis)) {
            lista_equipos = (List<byte[]>) in.readObject();
            System.out.println("Deserialización exitosa. Número de equipos: " + lista_equipos.size());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error durante la deserialización: " + e.getMessage());
            e.printStackTrace();
        }
        return lista_equipos;
    }

    //Serializamos El Array De los equipos Del usuario
    public byte[] serializar_equipos(List<byte[]> lista) throws ClassNotFoundException, IOException {
        byte[] serializedArray = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(lista);
            serializedArray = bos.toByteArray();
            System.out.println("Serialización exitosa. Tamaño del array: " + serializedArray.length + " bytes");
        } catch (IOException e) {
            System.err.println("Error durante la serialización: " + e.getMessage());
            e.printStackTrace();
        }
        return serializedArray;
    }
    
    //Serializamos El Array De los equipos Del usuario
//    public byte[] serializar_ids(String[] lista) throws ClassNotFoundException, IOException {
//        byte[] serializedArray = null;
//        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
//            out.writeObject(lista);
//            serializedArray = bos.toByteArray();
//            System.out.println("Serialización exitosa. Tamaño del array: " + serializedArray.length + " bytes");
//        } catch (IOException e) {
//            System.err.println("Error durante la serialización: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return serializedArray;
//    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idUsuario);
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.clave);
        hash = 53 * hash + Objects.hashCode(this.nivel);
        hash = 53 * hash + Objects.hashCode(this.experiencia);
        hash = 53 * hash + Arrays.hashCode(this.listaPersonajes);
        hash = 53 * hash + Arrays.hashCode(this.listaItems);
        hash = 53 * hash + Objects.hashCode(this.progresoCollection);
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
        final usuario other = (usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.experiencia, other.experiencia)) {
            return false;
        }
        if (!Arrays.equals(this.listaPersonajes, other.listaPersonajes)) {
            return false;
        }
        if (!Arrays.equals(this.listaItems, other.listaItems)) {
            return false;
        }
        return Objects.equals(this.progresoCollection, other.progresoCollection);
    }

    @Override
    public String toString() {
        return "usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", nivel=" + nivel + ", experiencia=" + experiencia + ", listaPersonajes=" + listaPersonajes + ", listaItems=" + listaItems + ", progresoCollection=" + progresoCollection + '}';
    }
   
}
