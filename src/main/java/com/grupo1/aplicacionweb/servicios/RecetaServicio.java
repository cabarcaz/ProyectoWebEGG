package com.grupo1.aplicacionweb.servicios;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.entidades.Receta;

import java.util.List;

public interface RecetaServicio {
    public List<Receta> listar();
    public void eliminar(Integer id);
    public void crear(Receta receta);
    public Receta findById(Integer id);
}
