package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.interfaz.ICarta;
import com.grupo1.aplicacionweb.repositorios.CartaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CartaServicio implements ICarta {

    @Autowired
    private CartaDao cartaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Carta> listar() {
        return cartaDao.findAll();
    }

    @Transactional
    @Override
    public void eliminar(Integer id) throws ErrorServicio {
        if (cartaDao.findById(id) != null) {
            Carta carta = findById(id);
            carta.setBaja(true);
            crear(carta);
        } else {
            throw new ErrorServicio("Error, ID nulo.");
        }
    }

    @Transactional
    @Override
    public void crear(Carta carta) throws ErrorServicio {
        if (carta != null) {
            if (cartaDao.findById(carta.getId()) != null) {
                //Agregar validaciones para las listas
                cartaDao.save(carta);
            } else {
                carta.setBaja(false);
                carta.setAlta(new Date());
                cartaDao.save(carta);
            }
        } else {
            throw new ErrorServicio("Error, componente nulo.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Carta findById(Integer id) {
        return cartaDao.findById(id).orElse(null);
    }
}
