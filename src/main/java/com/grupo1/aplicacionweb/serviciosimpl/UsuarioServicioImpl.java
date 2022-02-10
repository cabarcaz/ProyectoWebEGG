package com.grupo1.aplicacionweb.serviciosimpl;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.iservicios.UsuarioServicio;
import com.grupo1.aplicacionweb.repositorios.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

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
