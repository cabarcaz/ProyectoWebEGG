package com.grupo1.aplicacionweb.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/login")
    public String loginIndex(Model model, @RequestParam (required = false ) String error,
                             @RequestParam (required = false) String email,
                             @RequestParam (required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "el usuario ingresado o la contraseña son incorrectos");
        }
        if (email != null){
            model.addAttribute("email",email);
        }
        model.addAttribute("titulo", "Inicio");

        return "login";
    }


}