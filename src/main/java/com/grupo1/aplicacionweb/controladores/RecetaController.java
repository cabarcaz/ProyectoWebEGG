package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.servicio.IngredienteServicio;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/receta")
@SessionAttributes("receta")
public class RecetaController {
    @Autowired
    private RecetaServicio recetaServicio;
    @Autowired 
    private IngredienteServicio ingredienteServicio;

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
        for (int i = 0; i < 3; ++i) { // ingresar el numero de ingredientes que precisa el ususario
            receta.getIngredientes().add(new Ingrediente());
        }
        for (int i = 0; i < 3; ++i) { // ingresar el numero de pasos que precisa el ususario
            receta.getPasos().add(new Paso());
        }
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario ingreso de recetas");
        model.addAttribute("receta", receta);

        return "/receta/nuevo";
    }

    @PostMapping("/guardar")
    //
    public String guardar(@Valid @ModelAttribute Receta receta, SessionStatus ss, RedirectAttributes redirect, @RequestParam("file") MultipartFile imagen) {
                                //codigo para GUARDAR IMAGEN //
        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static//imagenes/receta");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                receta.setFoto(imagen.getOriginalFilename());
            } catch (IOException e) {
               redirect.addFlashAttribute("error",e.getMessage());
            }
        }
        for (int i = 0; i < receta.getPasos().size(); ++i) { // se asigna el orden de los pasos
           receta.getPasos().get(i).setNumero(i+1);
        }
        receta.setTiempoTotal(receta.getTiempoDeCoccion()+receta.getTiempoDePreparacion());
        recetaServicio.crear(receta);
        ss.setComplete();
        return "redirect:/receta/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, RedirectAttributes redirect,Model model) {
        if (id == null || recetaServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un receta con ese ID.");
            return "redirect:/receta/";
        } else {
            model.addAttribute("receta", recetaServicio.findById(id));
        }

        return "/receta/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        if (id == null || recetaServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un receta con ese ID.");
            return "redirect:/receta/";
        } else {
            recetaServicio.eliminar(id);
            redirect.addFlashAttribute("success","Su receta se elimino con exito!");
        }
        return "redirect:/receta/";
    }

    @GetMapping("/detalle/{id}")
    public String detalleRecetas(@PathVariable("id")Integer id, Model model, RedirectAttributes atribute){
        Receta receta = null;
        if(id != null){
            receta = recetaServicio.findById(id);
            if(id == null){
                atribute.addFlashAttribute("error", "El id de la receta no existe!");
                return "redirect:/receta/";
            }
        }else{
            atribute.addFlashAttribute("error", "Error con el id de la recera");
            return "redirect:/receta/";
        }
        List<Ingrediente> listIngredientes = ingredienteServicio.listar();

        model.addAttribute("titulo","Detalle");
        model.addAttribute("h1", "Detalle de la receta");
        model.addAttribute("recetas",receta);
        model.addAttribute("ingredientes", listIngredientes);

        return "/receta/detalles";
    }
}
