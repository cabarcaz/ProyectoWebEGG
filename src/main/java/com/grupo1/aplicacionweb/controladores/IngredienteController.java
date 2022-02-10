package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.iservicios.IngredienteSerivcio;
import com.grupo1.aplicacionweb.iservicios.RecetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteSerivcio ingredienteServicio;

    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("lista", ingredienteServicio.listar());
        return "ingrediente-lista";
    }

    @GetMapping("/toGuardar")
    private String toGuardar(Ingrediente ingrediente) {
        return "ingrediente-form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Ingrediente ingrediente, BindingResult result) {
        if (result.hasErrors()) {
            return "Ingrediente-form"; // VER COMO TRABAJAMOS LAS EXCEPCIONES.
        }
        ingrediente.setReceta(recetaServicio.findById(ingrediente.getReceta().getId())); // VALIDAR SI ES NULO EL ID

        ingredienteServicio.crear(ingrediente);
        return "redirect:/ingrediente/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            if (ingredienteServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                redirect.addAttribute(ingredienteServicio.findById(id));
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("lista",ingredienteServicio.listar());
            return "ingrediente-lista";
        }
        return "redirect:/ingrediente/toGuardar";
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
            model.addAttribute("lista",ingredienteServicio.listar());
            return "ingrediente-lista";
        }
        return "redirect:/ingrediente/lista";
    }
}
