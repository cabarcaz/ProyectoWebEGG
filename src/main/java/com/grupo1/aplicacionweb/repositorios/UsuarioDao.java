package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Integer> {
}
