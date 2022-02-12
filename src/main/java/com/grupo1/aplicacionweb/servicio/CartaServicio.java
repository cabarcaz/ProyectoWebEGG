package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.interfas.ICarta;
import com.grupo1.aplicacionweb.repositorios.CartaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaServicio implements ICarta {

    @Autowired
    private CartaDao cartaDao;


    @Override
    public List<Carta> listar() {
        return cartaDao.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        cartaDao.deleteById(id);
    }

    @Override
    public void crear(Carta carta) {
        cartaDao.save(carta);
    }

    @Override
    public Carta findById(Integer id) {
        return cartaDao.findById(id).orElse(null);
    }
}
