package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;

import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.enumeraciones.CategoriaPlato;
import com.grupo1.aplicacionweb.servicio.CartaServicio;

import com.grupo1.aplicacionweb.servicio.RecetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private RecetaServicio recetaServicio;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/")
    public String listar(Model model) {
        List<Carta> listaCarta = cartaServicio.listar();
        model.addAttribute("cartas", listaCarta);
        model.addAttribute("titulo", "Listado de Recetas");
        model.addAttribute("h1", "Listado de Recetas");
        return "/carta/lista";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/crear")
    public String crearCarta(Model model) {
        Carta carta = new Carta();
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario ingreso Nueva receta");
        model.addAttribute("carta", carta);
        List<Receta> recetasEntradas = recetaServicio.listarPorCategoria(CategoriaPlato.ENTRADA);
        model.addAttribute("recetasEntradas", recetasEntradas);
        List<Receta> recetasPrincpales = recetaServicio.listarPorCategoria(CategoriaPlato.PRINCIPAL);
        model.addAttribute("recetasPrincpales", recetasPrincpales);
        List<Receta> recetasPostres = recetaServicio.listarPorCategoria(CategoriaPlato.POSTRE);
        model.addAttribute("recetasPostres", recetasPostres);
        return "/carta/nuevo";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Carta carta, RedirectAttributes redirect) {
        try {
            cartaServicio.crear(carta);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/carta/";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        if (id != null) {
            model.addAttribute("carta", cartaServicio.findById(id));
        } else {
            redirect.addFlashAttribute("error", "Error con el ID");
            return "redirect:/carta/";
        }

        return "/carta/editar";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            cartaServicio.eliminar(id);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/carta/";
        }
        return "redirect:/carta/";
    }

}
