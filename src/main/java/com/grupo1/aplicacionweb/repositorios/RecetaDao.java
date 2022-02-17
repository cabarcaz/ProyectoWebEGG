package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaDao extends JpaRepository<Receta,Integer> {
}
