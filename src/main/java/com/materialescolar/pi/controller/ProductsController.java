package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.Product;

import com.materialescolar.pi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class ProductsController {


    @Autowired
    private ProductsRepository repo;


    //mapeamento pro template index home
    @GetMapping("/products")
    public String index(Model model) {
        List<Product> produtos = (List<Product>) repo.findAll();
        model.addAttribute("products", produtos);

        return "products/index";
    }

    //mapeamento pro template de add produto
    @GetMapping("/products/novo")
    public String novo(){

        return "products/novo";
    }

    //aqui de fato o produto é add ao bdd
    @PostMapping("/products/create")
    public String create(Product product){
        repo.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}/excluir")
    public String delete(@PathVariable Long id){
        repo.deleteById(id);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String search(@PathVariable Long id, Model model){
        Optional<Product> prod = repo.findById(id);
        if (prod.isPresent()) {
            model.addAttribute("product", prod.get());
            return "products/edit";
        } else {
            model.addAttribute("error", "Product not found");
            return "redirect:/products"; // Or another error page
        }
    }


    @PostMapping("/products/{id}/update")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {
        Optional<Product> existingProduct = repo.findById(id);
        if (existingProduct.isPresent()) {
            Product prodToUpdate = existingProduct.get();
            prodToUpdate.setNome(product.getNome());
            prodToUpdate.setValor(product.getValor());
            prodToUpdate.setDescricao(product.getDescricao());
            prodToUpdate.setBairro(product.getBairro());
            prodToUpdate.setRuaEnumero(product.getRuaEnumero());
            prodToUpdate.setNomeDaLoja(product.getNomeDaLoja());
            repo.save(prodToUpdate);
        }
        return "redirect:/products";
    }

}



