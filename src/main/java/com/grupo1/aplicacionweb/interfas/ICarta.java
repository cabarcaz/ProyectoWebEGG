package com.grupo1.aplicacionweb.interfas;

import com.grupo1.aplicacionweb.entidades.Carta;

import java.util.List;

public interface ICarta {
    public List<Carta> listar();
    public void eliminar(Integer id);
    public void crear(Carta carta);
    public Carta findById(Integer id);
}
