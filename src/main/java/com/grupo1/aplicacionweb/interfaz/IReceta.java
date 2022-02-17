package com.grupo1.aplicacionweb.interfaz;

import com.grupo1.aplicacionweb.entidades.Receta;

import java.util.List;

public interface IReceta{
    public List<Receta> listar();
    public void eliminar(Integer id);
    public void crear(Receta receta);
    public Receta findById(Integer id);
}
