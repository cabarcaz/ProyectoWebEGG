package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.interfas.InIngrediente;
import com.grupo1.aplicacionweb.repositorios.IngredienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class IngredienteServicio implements InIngrediente{

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

    @Transactional
    @Override
    public void crear(Ingrediente ingrediente) throws ErrorServicio {
        if (ingrediente != null) {
                ingredienteDao.save(ingrediente);
        } else {
            throw new ErrorServicio("Error, componente nulo.");
        }
    }

    @Override
    public Ingrediente findById(Integer id) {
        
        return ingredienteDao.findById(id).orElse(null);
    }
   
}
