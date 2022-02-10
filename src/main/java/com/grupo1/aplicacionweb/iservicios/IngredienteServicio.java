package com.grupo1.aplicacionweb.iservicios;

import com.grupo1.aplicacionweb.entidades.Ingrediente;

import java.util.List;

public interface IngredienteServicio {
    public List<Ingrediente> listar();
    public void eliminar(Integer id);
    public void crear(Ingrediente carta);
    public Ingrediente findById(Integer id);
}
