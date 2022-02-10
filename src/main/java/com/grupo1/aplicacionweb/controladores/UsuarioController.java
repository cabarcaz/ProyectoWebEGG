package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import com.grupo1.aplicacionweb.iservicios.CartaServicio;
import com.grupo1.aplicacionweb.iservicios.UsuarioServicio;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("lista", usuarioServicio.listar());
        return "usuario-lista";
    }

    @GetMapping("/toGuardar")
    private String toGuardar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario-form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario-form";// VER DONDE TRABAJAMOS LAS EXCEPCIONES.
        }
        usuario.setCarta(cartaServicio.findById(usuario.getCarta().getId()));
        usuarioServicio.crear(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@RequestParam("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            if (usuarioServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                redirect.addFlashAttribute("usuario", usuarioServicio.findById(id));

            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("lista", usuarioServicio.listar());
            return "usuario-lista";
        }
        return "redirect:/usuario/toGuardar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam("id") Integer id, Model model) {
        try {
            if (usuarioServicio.findById(id) == null) {
                throw new ErrorServicio("El id devuelve un valor nulo");
            } else {
                usuarioServicio.eliminar(id);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/usuario/lista";
    }
}
