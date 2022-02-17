package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.servicio.RecetaServicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/receta")
@SessionAttributes("receta")
public class RecetaController {
    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Receta> listaRecetas = recetaServicio.listar();

        model.addAttribute("recetas", listaRecetas);
        model.addAttribute("titulo", "Listado de  Recetas");
        model.addAttribute("h1", "Lista de Recetas Existentes");
        return "/receta/lista";
    }

    @GetMapping("/crear")
    public String crearReceta(Model model) {
        Receta receta = new Receta();
        for (int i = 0; i < 3; ++i) {
            receta.getIngredientes().add(new Ingrediente());
        }
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario ingreso de recetas");
        model.addAttribute("receta", receta);
        return "/receta/nuevo";
    }

    @PostMapping("/guardar")
    //@RequestParam("file") MultipartFile imagen
    public String guardar(@Valid @ModelAttribute Receta receta, SessionStatus ss, Model model) {
                                //GUARDAR IMAGEN //
//        if (!imagen.isEmpty()) {
//            Path directorioImagenes = Paths.get("src//main//resources//static//imagenes/receta");
//            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
//            try {
//                byte[] bytesImg = imagen.getBytes();
//                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
//                Files.write(rutaCompleta, bytesImg);
//                receta.setFoto(imagen.getOriginalFilename());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        ///////////////////////////////////////////////////////////////////////////////

        recetaServicio.crear(receta);
        ss.setComplete();
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
    public String detalleRecetas(Model model) {
        model.addAttribute("h1", "Detalle de la receta");
        return "/receta/detalles";
    }
}
