package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.interfas.IUsuario;
import com.grupo1.aplicacionweb.repositorios.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuario{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listar() {
        return usuarioDao.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public void crear(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }
}
