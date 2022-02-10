package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.iservicios.IngredienteSerivcio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteSerivcio ingredienteServicio;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("lista", ingredienteServicio.listar());
        return "ingrediente-lista";
    }

    @GetMapping("/guardar")
    private String toGuardar(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "ingrediente-form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Ingrediente ingrediente, BindingResult result) {
        if (result.hasErrors()) {

            // VER COMO TRABAJAMOS LAS EXCEPCIONES.

            return "Ingrediente-form";
        }
        ingredienteServicio.crear(ingrediente);
        return "redirect:/ingrediente/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model) {
        try {
            if (ingredienteServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                ingredienteServicio.crear(ingredienteServicio.findById(id));
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "ingrediente-lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam("id") Integer id, Model model) {
        try {
            if (ingredienteServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                ingredienteServicio.eliminar(id);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }

        return "ingrediente-lista";
    }
}
