package com.materialescolar.pi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    @GetMapping("/usuario_page")
    public String usuario_page(Model model){
        model.addAttribute("nome", "Cleyton");
        return "usuario/usuario_page";
    }



    }


