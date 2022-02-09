package com.grupo1.aplicacionweb.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name="nombre")
    private String nombre;
    @NotEmpty
    @Column(name="apellido")
    private String apellido;
    @NotEmpty
    @Column(name="email")
    private String email;
    @NotEmpty
    @Column(name="password")
    private String password;
    @NotEmpty
    @Column(name="foto")
    private String foto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date baja;

}
