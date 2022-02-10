package com.grupo1.aplicacionweb.servicios;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.entidades.Ingrediente;

import java.util.List;

public interface IngredienteSerivcio {
    public List<Ingrediente> listar();
    public void eliminar(Integer id);
    public void crear(Ingrediente carta);
    public Ingrediente findById(Integer id);
}
