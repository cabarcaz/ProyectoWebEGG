package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.resource.CachingResourceTransformer;

import java.util.List;

@Repository
public interface IngredienteDao extends JpaRepository<Ingrediente,Integer> {
}
