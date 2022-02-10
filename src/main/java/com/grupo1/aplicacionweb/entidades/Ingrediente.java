package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ingredientes")
public class Ingrediente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name="nombre")
    private String nombre;
    @NotEmpty
    @Column(name="cantidad")
    private String cantidad;
    @ManyToOne
    @JoinColumn (name ="ingrediente_id")
    private Receta receta;
}
