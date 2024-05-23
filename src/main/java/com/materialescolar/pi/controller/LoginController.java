package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.UserModel;
import com.materialescolar.pi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, String username, String password){
        UserModel user = this.repo.login(username, password);

        if(user != null) {
            return "redirect:/products";
        }
        model.addAttribute("error", "Usuário ou senha inválidos");

        return "login/index";
    }

}
