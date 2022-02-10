package com.grupo1.aplicacionweb.iservicios;

import com.grupo1.aplicacionweb.entidades.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioServicio extends UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

  public List<Usuario> listar();
  public void eliminar(Integer id);
  public void crear(Usuario usuario);
  public Usuario findById(Integer id);
}