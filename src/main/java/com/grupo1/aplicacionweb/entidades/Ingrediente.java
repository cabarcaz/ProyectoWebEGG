package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

/*
@Getter - importamos para usar lombok
@Setter
*/

@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    private static long serialVersionUID = 3098791991667236102L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    @NotEmpty
    @Column(name = "cantidad")
    private String cantidad;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the receta
     */
    public Receta getReceta() {
        return receta;
    }

    /**
     * @param receta the receta to set
     */
    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
