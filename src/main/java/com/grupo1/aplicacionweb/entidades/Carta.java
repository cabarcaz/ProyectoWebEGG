package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cartas")
public class Carta implements Serializable {

    private static long serialVersionUID = -7819236374992397102L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)

    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE)
    private Date semana;

    @ManyToOne
    @JoinColumn(name = "entrada_lunes_id")
    private Receta entradaLunes;
    @ManyToOne
    @JoinColumn(name = "principal_lunes_id")
    private Receta principalLunes;
    @ManyToOne
    @JoinColumn(name = "postre_lunes_id")
    private Receta postreLunes;
    @ManyToOne
    @JoinColumn(name = "entrada_martes_id")
    private Receta entradaMartes;
    @ManyToOne
    @JoinColumn(name = "principal_martes_id")
    private Receta principalMartes;
    @ManyToOne
    @JoinColumn(name = "postre_martes_id")
    private Receta postreMartes;
    @ManyToOne
    @JoinColumn(name = "entrada_miercoles_id")
    private Receta entradaMiercoles;
    @ManyToOne
    @JoinColumn(name = "principal_miercoles_id")
    private Receta principalMiercoles;
    @ManyToOne
    @JoinColumn(name = "postre_miercoles_id")
    private Receta postreMiercoles;
    @ManyToOne
    @JoinColumn(name = "entrada_jueves_id")
    private Receta entradaJueves;
    @ManyToOne
    @JoinColumn(name = "principal_jueves_id")
    private Receta principalJueves;
    @ManyToOne
    @JoinColumn(name = "postre_jueves_id")
    private Receta postreJueves;
    @ManyToOne
    @JoinColumn(name = "entrada_viernes_id")
    private Receta entradaViernes;
    @ManyToOne
    @JoinColumn(name = "principal_viernes_id")
    private Receta principalViernes;
    @ManyToOne
    @JoinColumn(name = "postre_viernes_id")
    private Receta postreViernes;
    @ManyToOne
    @JoinColumn(name = "entrada_sabado_id")
    private Receta entradaSabado;
    @ManyToOne
    @JoinColumn(name = "principal_sabado_id")
    private Receta principalSabado;
    @ManyToOne
    @JoinColumn(name = "postre_sabado_id")
    private Receta postreSabado;
    @ManyToOne
    @JoinColumn(name = "entrada_domingo_id")
    private Receta entradaDomingo;
    @ManyToOne
    @JoinColumn(name = "principal_domingo_id")
    private Receta principalDomingo;
    @ManyToOne
    @JoinColumn(name = "postre_domingo_id")
    private Receta postreDomingo;

    public Receta getPostreDomingo() {
        return postreDomingo;
    }

    public Receta getPrincipalDomingo() {
        return principalDomingo;
    }

    public Receta getEntradaDomingo() {
        return entradaDomingo;
    }

    public Receta getPostreSabado() {
        return postreSabado;
    }

    public Receta getPrincipalSabado() {
        return principalSabado;
    }

    public Receta getEntradaSabado() {
        return entradaSabado;
    }

    public Receta getPostreViernes() {
        return postreViernes;
    }

    public Receta getPrincipalViernes() {
        return principalViernes;
    }

    public Receta getEntradaViernes() {
        return entradaViernes;
    }

    public Receta getPostreJueves() {
        return postreJueves;
    }

    public Receta getPrincipalJueves() {
        return principalJueves;
    }

    public Receta getEntradaJueves() {
        return entradaJueves;
    }

    public Receta getPostreMiercoles() {
        return postreMiercoles;
    }

    public Receta getPrincipalMiercoles() {
        return principalMiercoles;
    }

    public Receta getEntradaMiercoles() {
        return entradaMiercoles;
    }

    public Receta getPostreMartes() {
        return postreMartes;
    }

    public Receta getPrincipalMartes() {
        return principalMartes;
    }

    public Receta getEntradaMartes() {
        return entradaMartes;
    }

    public Receta getPrincipalLunes() {
        return principalLunes;
    }

    public Receta getPostreLunes() {
        return postreLunes;
    }

    public Receta getEntradaLunes() {
        return entradaLunes;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Carta.serialVersionUID = serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
