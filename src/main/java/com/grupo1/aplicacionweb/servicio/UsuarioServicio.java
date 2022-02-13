package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.enumeraciones.Roles;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.interfas.IUsuario;
import com.grupo1.aplicacionweb.repositorios.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServicio implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listar() {
        return usuarioDao.findAll();
    }

    @Override
    public void eliminar(Integer id) {
//        usuarioDao.deleteById(id);
        Usuario usuario = findById(id);
        usuario.setBaja(true);
        usuarioDao.save(usuario);

    }

    @Override
    public void crear(Usuario usuario) throws ErrorServicio {

        if (usuario != null) {
            if (usuario.getPassword2().equals(usuario.getPassword())) {
                if (usuario.getId() == null) {
                    usuario.setAlta(new Date());
                    usuario.setBaja(false);
                    usuario.setRol(Roles.USER);
                }
                usuarioDao.save(usuario);
            } else {
                throw new ErrorServicio("Password no coincide");
            }
        } else {
            throw new ErrorServicio("Error,el usuario es nulo.");
        }
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }
}
