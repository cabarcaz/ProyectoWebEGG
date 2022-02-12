package com.grupo1.aplicacionweb.interfas;

import java.util.List;

import com.grupo1.aplicacionweb.entidades.Ingrediente;

public interface InIngrediente { 

    public List<Ingrediente> listar();
    public void eliminar(Integer id);
    public void crear(Ingrediente ingrediente);
    public Ingrediente findById(Integer id);
}
