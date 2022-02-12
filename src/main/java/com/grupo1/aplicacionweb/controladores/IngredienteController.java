package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.servicio.IngredienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteServicio ingredienteServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Ingrediente> listaIngredientes = ingredienteServicio.listar();
        model.addAttribute("ingredientes", listaIngredientes);
        model.addAttribute("titulo", "Listado Ingredientes");
        model.addAttribute("h1", "Lista de Ingredientes.");
        return "/ingrediente/lista";
    }

    @GetMapping("/crear")
    public String crearIngrediente(Model model) {
        Ingrediente ingredientes = new Ingrediente();
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario Ingreso nuevo Ingrediente");
        model.addAttribute("ingrediente", ingredientes);
        return "/ingrediente/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Ingrediente ingrediente, Model model) {
        ingredienteServicio.crear(ingrediente);
        return "redirect:/ingrediente/";
    }

    @GetMapping("/editar")
    public String editar() {

        return "/ingrediente/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar() {

        return "redirect:/ingrediente/";
    }
}
