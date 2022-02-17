package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cartas")
public class Carta implements Serializable {

    private static long serialVersionUID = -7819236374992397102L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty (message = "Este campo es obligatorio.")
    private String nombre;

    @ManyToMany(mappedBy = "cartas", cascade = CascadeType.ALL)
    private List<Receta> recetas = new ArrayList<>();

    @OneToMany(mappedBy = "carta", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;

    private Boolean baja;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }
}


