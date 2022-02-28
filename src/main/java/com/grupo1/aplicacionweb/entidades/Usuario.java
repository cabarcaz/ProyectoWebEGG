package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;

import com.grupo1.aplicacionweb.enumeraciones.Roles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {


    private static long serialVersionUID = -1299678208192314499L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "nombre es obligatorio")
    @Column(name = "nombre")
    private String nombre;

//    @NotEmpty(message = "apellido es obligatorio.")
    @Column(name = "apellido")
    private String apellido;

//    @NotEmpty(message = "email es obligatorio.")
    @Email
    @Column(name = "email")
    private String email;

//    @NotEmpty(message = "password es obligatorio.")
    @Column(name = "password")
    private String password;

//    @NotEmpty(message = "password2 es obligatorio.")
    @Column(name = "password2")
    private String password2;

//    @NotEmpty(message = "foto es obligatoria.")
    @Column(name = "foto")
    private String foto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;

    @Column(name = "baja")
    private Boolean baja;

    @Enumerated(EnumType.STRING)
    private Roles rol;


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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
