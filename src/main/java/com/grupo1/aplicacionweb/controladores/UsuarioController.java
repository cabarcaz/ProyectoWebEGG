package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.enumeraciones.Roles;
import com.grupo1.aplicacionweb.servicio.CartaServicio;
import com.grupo1.aplicacionweb.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Usuario> listaUsuario = usuarioServicio.listar();
        model.addAttribute("usuarios", listaUsuario);
        model.addAttribute("titulo", "Listado Usuaarios");
        model.addAttribute("h1", "Listado de Usuarios");
        return "/usuario/lista";
    }

    @GetMapping("/crear")
    public String crearUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario ingreso nuevo usuario");
        model.addAttribute("usuario", usuario);
        return "/usuario/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "/usuario/nuevo";
        }
        try {
            if (usuario.getCarta() == null) {
                usuario.setCarta(null);
                usuarioServicio.crear(usuario);
            } else {
                usuario.setCarta(cartaServicio.findById(usuario.getCarta().getId()));
                usuarioServicio.crear(usuario);
                redirect.addFlashAttribute("success", "Su menu se ha asignado con EXITO.");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/usuario/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, RedirectAttributes redirect, Model model) {
        if (id == null || usuarioServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un usuario con ese ID.");
            return "redirect:/usuario/";
        } else {
            List<Roles> roles = new ArrayList<Roles>(Arrays.asList(Roles.values()));
            model.addAttribute("usuario", usuarioServicio.findById(id));
            model.addAttribute("roles", roles);

        }

        return "/usuario/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirect) {

        if (id == null || usuarioServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un usuario con ese ID.");
            return "redirect:/usuario/";
        } else {
            usuarioServicio.eliminar(id);
            redirect.addFlashAttribute("success", "Su usuario se elimino con exito!");
        }

        return "redirect:/usuario/";
    }

    @GetMapping("/pass/{id}")
    public String nuevoPass(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("usuario", usuarioServicio.findById(id));
        return "/usuario/nuevo-pass";
    }

    //-------------------------------------FIN CRUD-----------------------------------------------------------------------//


}
