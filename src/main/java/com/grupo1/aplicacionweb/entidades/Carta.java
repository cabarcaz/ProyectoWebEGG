package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas")
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date baja;

    @OneToMany(mappedBy = "carta")
    private List<Receta> recetas;

    @OneToMany(mappedBy = "carta")
    private List<Usuario> usuarios;
}
