package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.servicio.CartaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("cartas", listaCarta);
        model.addAttribute("titulo", "Listado de Recetas");
        model.addAttribute("h1", "Listado de Recetas");
        return "/carta/lista";
    }

    @GetMapping("/crear")
    public String crearCarta(Model model) {
        Carta carta = new Carta();
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario ingreso Nueva receta");
        model.addAttribute("carta", carta);
        return "/carta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Carta carta, RedirectAttributes redirect) {
        try {
            cartaServicio.crear(carta);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/carta/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model, RedirectAttributes redirect) {
        if (id != null) {
            model.addAttribute("carta", cartaServicio.findById(id));
        } else {
            redirect.addFlashAttribute("error", "Error con el ID");
            return "redirect:/carta/";
        }

        return "/carta/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            cartaServicio.eliminar(id);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/carta/";
        }
        return "redirect:/carta/";
    }
}
