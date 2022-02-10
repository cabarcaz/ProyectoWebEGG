package com.grupo1.aplicacionweb.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "preparacion")
    private String preparacion; // considerar armar arraylist para iterar en front
    @Column(name = "foto")
    private String foto;
    @Column(name = "comentario")
    private String comentario;

    @OneToMany (mappedBy = "receta")
    private List<Ingrediente> ingredientes;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Carta carta;
    
    @NotEmpty
    @Column(name = "tiempo_coccion")
    private String tiempoDeCoccion;
    @NotEmpty
    @Column(name = "tiempo_preparacion")
    private String tiempoDePreparacion;
    @NotEmpty
    @Column(name = "tiempo_total")
    private String tiempoTotal;
    @NotEmpty
    @Column(name = "procion")
    private String porcion;

}
