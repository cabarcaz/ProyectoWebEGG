package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.interfas.ICarta;
import com.grupo1.aplicacionweb.repositorios.CartaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartaServicio implements ICarta {

    @Autowired
    private CartaDao cartaDao;


    @Override
    public List<Carta> listar() {
        return cartaDao.findAll();
    }

    @Override
    public void eliminar(Integer id) throws ErrorServicio{
        if (cartaDao.findById(id) != null) {
            Carta carta =findById(id);
            carta.setBaja(true);
            crear(carta);
        }else {
            throw new ErrorServicio("Error, ID nulo.");
        }
    }

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

    @Override
    public Carta findById(Integer id) {
        return cartaDao.findById(id).orElse(null);
    }
}
