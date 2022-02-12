package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.servicio.CartaServicio;

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
@RequestMapping("/carta")
public class CartaController {
    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Carta> listaCarta = cartaServicio.listar();
        model.addAttribute("cartas",listaCarta);
        model.addAttribute("titulo", "Listado de Recetas");
        model.addAttribute("h1","Listado de Recetas");
        return "/carta/lista";
    }

    @GetMapping("/crear")
    public String crearCarta(Model model) {
        Carta cartas = new Carta();
        model.addAttribute("titulo","Formulario");
        model.addAttribute("h1", "Formulario ingreso Nueva receta");
        model.addAttribute("carta", cartas);
        return "/carta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Carta carta, Model model) {
        cartaServicio.crear(carta);
        return "redirect:/carta/";
    }

    @GetMapping("/editar")
    public String editar() {
        
        return "/carta/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar() {
       
        return "redirect:/carta/";
    }
}
