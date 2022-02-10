package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/*
@Getter - importamos para usar lombok
@Setter
*/

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static long serialVersionUID = -3210120901686041769L;

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
    @JoinColumn(name = "carta_id")
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
     * @return the preparacion
     */
    public String getPreparacion() {
        return preparacion;
    }

    /**
     * @param preparacion the preparacion to set
     */
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the ingredientes
     */
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * @return the carta
     */
    public Carta getCarta() {
        return carta;
    }

    /**
     * @param carta the carta to set
     */
    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    /**
     * @return the tiempoDeCoccion
     */
    public String getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    /**
     * @param tiempoDeCoccion the tiempoDeCoccion to set
     */
    public void setTiempoDeCoccion(String tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    /**
     * @return the tiempoDePreparacion
     */
    public String getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    /**
     * @param tiempoDePreparacion the tiempoDePreparacion to set
     */
    public void setTiempoDePreparacion(String tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    /**
     * @return the tiempoTotal
     */
    public String getTiempoTotal() {
        return tiempoTotal;
    }

    /**
     * @param tiempoTotal the tiempoTotal to set
     */
    public void setTiempoTotal(String tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    /**
     * @return the porcion
     */
    public String getPorcion() {
        return porcion;
    }

    /**
     * @param porcion the porcion to set
     */
    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

}
