package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static long serialVersionUID = -3210120901686041769L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "nombre")
    private String nombre;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "preparacion")
    private String preparacion; // considerar armar arraylist para iterar en front

//    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "foto")
    private String foto;

//    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "comentario")
    private String comentario;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "tiempo_coccion")
    private String tiempoDeCoccion;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "tiempo_preparacion")
    private String tiempoDePreparacion;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "tiempo_total")
    private String tiempoTotal;

    @NotEmpty (message = "Este campo es obligatorio.")
    @Column(name = "porcion")
    private String porcion;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "receta_ingrediente",
            joinColumns = {@JoinColumn(name = "receta_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingrediente_id")})
    private List<Ingrediente> ingredientes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "receta_carta",
            joinColumns = {@JoinColumn(name = "receta_id")},
            inverseJoinColumns = {@JoinColumn(name = "carta_id")})
    private List<Carta> cartas;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Receta.serialVersionUID = serialVersionUID;
    }

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

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(String tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public String getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(String tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(String tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
