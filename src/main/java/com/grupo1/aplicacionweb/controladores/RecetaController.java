package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.servicio.IngredienteServicio;
import com.grupo1.aplicacionweb.servicio.RecetaServicio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("recetas",listaRecetas);
        model.addAttribute("titulo","Listado de  Recetas");
        model.addAttribute("h1","Lista de Recetas Existentes");
        return "/receta/lista";
    }

    @GetMapping("/crear")
    public String crearReceta(Model model) {
        Receta receta = new Receta();
        model.addAttribute("titulo","Formulario");
        model.addAttribute("h1","Formulario ingreso de recetas");
        model.addAttribute("recetas",receta);
        return "/receta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Receta receta, SessionStatus ss,Model model,@RequestParam("file") MultipartFile imagen) {

        if(!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static//imagenes/receta");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                receta.setFoto(imagen.getOriginalFilename());
            }catch (IOException e){
                e.printStackTrace();
            }
        }

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
