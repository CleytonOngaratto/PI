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


    @GetMapping("/products")
    public String index(Model model) {
        List<Product> produtos = (List<Product>) repo.findAll();
        model.addAttribute("products", produtos);

        return "products/index";
    }

    @GetMapping("/products/new")
    public String novo(){

        return "products/new";
    }

    @PostMapping("/products/create")
    public String create(Product product){
        repo.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}/excluir")
    public String excluir(@PathVariable Long id){
        repo.deleteById(id);

        return "redirect:/products";
    }


//
//    @GetMapping("/getAllProdutos")
//    public ResponseEntity<List<Product>> getAllProdutos() {
//        try {
//            List<Product> listaDeProdutos = new ArrayList<>();
//            produtosRepository.findAll().forEach(listaDeProdutos::add);
//
//            if (listaDeProdutos.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(listaDeProdutos, HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/getProdutoById/{id}")
//    public ResponseEntity<Product> getProdutoById(@PathVariable Long id) {
//        Optional<Product> produtoObj = produtosRepository.findById(id);
//        if (produtoObj.isPresent()) {
//            return new ResponseEntity<>(produtoObj.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/addProduto")
//    public ResponseEntity<Product> addBook(@RequestBody Product produto) {
//        try {
//            Product produtoObj = produtosRepository.save(produto);
//            return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/updateProduto/{id}")
//    public ResponseEntity<Product> updateBook(@PathVariable Long id, @RequestBody Product produto) {
//        try {
//            Optional<Product> produtoData = produtosRepository.findById(id);
//            if (produtoData.isPresent()) {
//                Product updatedProdutoData = produtoData.get();
//                updatedProdutoData.setNome(produto.getNome());
//                updatedProdutoData.setValor(produto.getValor());
//                updatedProdutoData.setDescricao(produto.getDescricao());
//
//                Product produtoObj = produtosRepository.save(updatedProdutoData);
//                return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
//            }
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/deleteProdutoById/{id}")
//    public ResponseEntity<HttpStatus> deleteProduto(@PathVariable Long id) {
//        try {
//            produtosRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/deleteAllProdutos")
//    public ResponseEntity<HttpStatus> deleteAllProdutos() {
//        try {
//            produtosRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//


}



