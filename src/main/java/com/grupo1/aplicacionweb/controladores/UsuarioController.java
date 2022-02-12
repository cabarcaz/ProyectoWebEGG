package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.servicio.UsuarioServicio;

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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String listar(Model model) {
        List<Usuario> listaUsuario = usuarioServicio.listar();
        model.addAttribute("usuarios", listaUsuario);
        model.addAttribute("titulo","Listado Usuaarios");
        model.addAttribute("h1", "Listado de Usuarios");
        return "/usuario/lista";
    }

    @GetMapping("/crear")
    public String crearUsuario(Model model) {
       Usuario usuarios= new Usuario();
       model.addAttribute("titulo", "Formulario");
       model.addAttribute("h1", "Formulario ingreso nuevo usuario"); 
       model.addAttribute("usuario", usuarios);
        return "/usuario/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Usuario usuario, Model model) {
        usuarioServicio.crear(usuario);
        return "redirect:/usuario/";
    }

    @GetMapping("/editar")
    public String editar() {
       
        return "/ingrediente/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar() {
       
        return "redirect:/usuario/";
    }
}
