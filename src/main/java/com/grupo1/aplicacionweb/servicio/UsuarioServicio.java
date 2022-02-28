package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.enumeraciones.Roles;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.interfaz.IUsuario;
import com.grupo1.aplicacionweb.repositorios.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServicio implements IUsuario, UserDetailsService {

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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (usuario != null) {
            if (usuario.getPassword2().equals(usuario.getPassword())) {
                if (usuario.getId() == null) {
                    usuario.setPassword(encoder.encode(usuario.getPassword()));
                    usuario.setPassword2(encoder.encode(usuario.getPassword2()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        try {
//            Usuario usuario = usuarioDao.findByEmail(email);
//            User user;
//            return new User(email, usuario.getPassword());
//        } catch (Exception e) {
//            throw new UsernameNotFoundException("el usuario solicitado no existe");
//        }
//        return null;
//
//    }
}
