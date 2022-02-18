package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaDao extends JpaRepository<Receta,Integer> {

    @Query("SELECT c FROM recetas c WHERE c.categoria = :categoria")
    public List<Receta> buscarPorCategoria(@Param("categoria") String categoria);
}
