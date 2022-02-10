package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.iservicios.CartaServicio;
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
@RequestMapping("/receta")
public class RecetaController {
    @Autowired
    private RecetaServicio recetaServicio;
    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("lista", recetaServicio.listar());
        return "receta-lista";
    }

    @GetMapping("/toGuardar")
    private String toGuardar(Receta receta) {
        return "receta-form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Receta receta, BindingResult result) {
        if (result.hasErrors()) {

            // VER DONDE TRABAJAMOS LAS EXCEPCIONES.

            return "receta-form";
        }
        receta.setCarta(cartaServicio.findById(receta.getCarta().getId())); // VALIDAR SI ES NULO
        recetaServicio.crear(receta);
        return "redirect:/receta/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            if (recetaServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                redirect.addFlashAttribute("receta",recetaServicio.findById(id));
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("lista", recetaServicio.listar());
            return "receta-lista";
        }
        return "redirect:/receta/toGuardar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam("id") Integer id, Model model) {
        try {
            if (recetaServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                recetaServicio.eliminar(id);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "receta-lista";
        }
        return "redirect:/receta/lista";
    }
}
