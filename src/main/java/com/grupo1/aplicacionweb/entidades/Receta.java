package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
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


    //    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "foto")
    private String foto;

    //    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "comentario")
    private String comentario;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_coccion")
    private Integer tiempoDeCoccion;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_preparacion")
    private Integer tiempoDePreparacion;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_total")
    private Integer tiempoTotal;

    private String porcion;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "porcion")
    @OneToMany( mappedBy = "receta" ,cascade = CascadeType.ALL)
    private List<Paso> pasos = new ArrayList<>();
    @JoinTable(
            name = "receta_ingrediente",
            joinColumns = {@JoinColumn(name = "receta_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingrediente_id")})
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "receta_carta",
            joinColumns = {@JoinColumn(name = "receta_id")},
            inverseJoinColumns = {@JoinColumn(name = "carta_id")})
    private List<Carta> cartas = new ArrayList<>();


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

    public List<Paso> getPasos() {
        return pasos;
    }

    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
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

    public Integer getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(Integer tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public Integer getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(Integer tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
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
