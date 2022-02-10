package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.iservicios.CartaServicio;
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
@RequestMapping("/carta")
public class CartaController {
    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("lista", cartaServicio.listar());
        return "carta-lista";
    }

    @GetMapping("/toGuardar")
    private String toGuardar(Carta carta) {
        return "carta-form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Carta carta, BindingResult result) {
        if (result.hasErrors()) {
            return "carta-form"; // VER DONDE TRABAJAMOS LAS EXCEPCIONES.
        }
        cartaServicio.crear(carta);
        return "redirect:/carta/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model) {
        try {
            if (cartaServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                cartaServicio.crear(cartaServicio.findById(id));
            }
        } catch (Exception e) {
            
            model.addAttribute("error", e.getMessage());
            model.addAttribute("lista", cartaServicio.listar());
            return "receta-lista";
        }
        return "carta-lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam("id") Integer id, Model model) {
        try {
            if (cartaServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                cartaServicio.eliminar(id);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }

        return "carta-lista";
    }
}
