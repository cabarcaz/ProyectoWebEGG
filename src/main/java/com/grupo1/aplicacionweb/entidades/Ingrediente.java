package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recetas")
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
}
