package com.grupo1.aplicacionweb.servicios;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.repositorios.IngredienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServicioImpl implements IngredienteSerivcio {
    @Autowired
    private IngredienteDao ingredienteDao;

    @Override
    public List<Ingrediente> listar() {
        return ingredienteDao.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        ingredienteDao.deleteById(id);
    }

    @Override
    public void crear(Ingrediente ingrediente) {
        ingredienteDao.save(ingrediente);
    }

    @Override
    public Ingrediente findById(Integer id) {
        return ingredienteDao.findById(id).orElse(null);
    }
}
