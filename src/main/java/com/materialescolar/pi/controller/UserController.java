package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.UserModel;
import com.materialescolar.pi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "register/index";
    }

    @PostMapping("/register/create")
    public String registerUser(@ModelAttribute UserModel user, RedirectAttributes redirectAttributes) {
        repo.save(user);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/register";
    }
}
