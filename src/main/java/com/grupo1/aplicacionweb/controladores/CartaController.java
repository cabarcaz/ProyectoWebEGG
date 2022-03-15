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
        model.addAttribute("titulo", "Listado de Cartas");
        model.addAttribute("h1", "Listado de Cartas");
        return "/carta/lista";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/crear")
    public String crearCarta(Model model) {
        Carta carta = new Carta();
        List<Receta> recetasEntradas = recetaServicio.listarPorCategoria(CategoriaPlato.ENTRADA);
        List<Receta> recetasPrincpales = recetaServicio.listarPorCategoria(CategoriaPlato.PRINCIPAL);
        List<Receta> recetasPostres = recetaServicio.listarPorCategoria(CategoriaPlato.POSTRE);

        // for (int i = 0; i < 3; ++i) {carta.getLunes().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getMartes().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getMiercoles().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getJueves().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getViernes().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getSabado().add(new Receta());}
        // for (int i = 0; i < 3; ++i) {carta.getDomingo().add(new Receta());}

        System.out.println(carta.getId());

        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Planificación Semanal");
        model.addAttribute("carta", carta);
        model.addAttribute("recetasEntradas", recetasEntradas);
        model.addAttribute("recetasPrincpales", recetasPrincpales);
        model.addAttribute("recetasPostres", recetasPostres);

        return "/carta/nuevo";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Carta carta, RedirectAttributes redirect) {

        System.out.println(carta.getId());

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

    @GetMapping("/listaReceta")
    public String listaRecetaCarta(Model model){
        model.addAttribute("titulo", "Detalle Simple");
        model.addAttribute("h1", "Lista de Recetas");
        List<Receta> listadoRecetas = recetaServicio.listar();
        model.addAttribute("recetas", listadoRecetas);

        return "/carta/listarecetacarta";
    } 

}
