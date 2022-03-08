package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cartas")
public class Carta implements Serializable {

    private static long serialVersionUID = -7819236374992397102L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> lunes = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> martes = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> miercoles = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> jueves = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> viernes = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> sabado = new ArrayList<>();
    @OneToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> domingo = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Carta.serialVersionUID = serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Receta> getLunes() {
        return lunes;
    }

    public void setLunes(List<Receta> lunes) {
        this.lunes = lunes;
    }

    public List<Receta> getMartes() {
        return martes;
    }

    public void setMartes(List<Receta> martes) {
        this.martes = martes;
    }

    public List<Receta> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(List<Receta> miercoles) {
        this.miercoles = miercoles;
    }

    public List<Receta> getJueves() {
        return jueves;
    }

    public void setJueves(List<Receta> jueves) {
        this.jueves = jueves;
    }

    public List<Receta> getViernes() {
        return viernes;
    }

    public void setViernes(List<Receta> viernes) {
        this.viernes = viernes;
    }

    public List<Receta> getSabado() {
        return sabado;
    }

    public void setSabado(List<Receta> sabado) {
        this.sabado = sabado;
    }

    public List<Receta> getDomingo() {
        return domingo;
    }

    public void setDomingo(List<Receta> domingo) {
        this.domingo = domingo;
    }
}


