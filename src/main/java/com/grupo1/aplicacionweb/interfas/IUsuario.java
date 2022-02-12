package com.grupo1.aplicacionweb.interfas;

import com.grupo1.aplicacionweb.entidades.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuario {

  public List<Usuario> listar();
  public void eliminar(Integer id);
  public void crear(Usuario usuario);
  public Usuario findById(Integer id);
}