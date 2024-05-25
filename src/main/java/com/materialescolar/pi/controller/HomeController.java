package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.Product;
import com.materialescolar.pi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ProductsRepository repo;


    //trazer todos os produtos pro meu home
    @GetMapping("/")
    public String home(Model model) {
        List<Product> produtos = (List<Product>) repo.findAll();
        model.addAttribute("products", produtos);

        return "home/index";
    }

}
