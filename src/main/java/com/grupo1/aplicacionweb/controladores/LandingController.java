package com.grupo1.aplicacionweb.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class LandingController {

    @GetMapping("/")
    public String landing(Model model){
        model.addAttribute("titulo", "Inicio");
        return "/main/landing";
    }
   
}
