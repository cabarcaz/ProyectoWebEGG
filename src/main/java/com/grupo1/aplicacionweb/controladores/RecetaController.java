package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.servicio.RecetaServicio;

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
@RequestMapping("/receta")
public class RecetaController {
    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Receta> listaRecetas = recetaServicio.listar();
        model.addAttribute("recetas",listaRecetas);
        model.addAttribute("titulo","Listadi Recetas");
        model.addAttribute("h1","Formulario ingreso de nueva receta");
        return "/receta/lista";
    }

    @GetMapping("/crear")
    public String crearReceta(Model model) {
        Receta receta = new Receta();
        model.addAttribute("receta",receta);
        model.addAttribute("titulo","Formulario");
        model.addAttribute("h1","Formulario ingreso de recetas");
        return "/receta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Receta receta,Model model) {
        recetaServicio.crear(receta);
        return "redirect:/receta/";
    }

    @GetMapping("/editar")
    public String editar() {
       
        return "/receta/editar";
    }

    @GetMapping("/eliminar")
    public String eliminar() {
        
        return "redirect:/receta/";
    }

    @GetMapping("/detalle")
    public String detalleRecetas(Model model){
        model.addAttribute("h1", "Detalle de la receta");
        return "/receta/detalles";
    }
}
