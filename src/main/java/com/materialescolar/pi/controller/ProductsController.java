package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.ProductModel;

import com.materialescolar.pi.repository.ProductsRepository;
import com.materialescolar.pi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductsRepository produtosRepository;


    @GetMapping("/products")
    public String usuario_page(){
        return "products/index";
    }


    @GetMapping("/getAllProdutos")
    public ResponseEntity<List<ProductModel>> getAllProdutos() {
        try {
            List<ProductModel> listaDeProdutos = new ArrayList<>();
            produtosRepository.findAll().forEach(listaDeProdutos::add);

            if (listaDeProdutos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listaDeProdutos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProdutoById/{id}")
    public ResponseEntity<ProductModel> getProdutoById(@PathVariable Long id) {
        Optional<ProductModel> produtoObj = produtosRepository.findById(id);
        if (produtoObj.isPresent()) {
            return new ResponseEntity<>(produtoObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProduto")
    public ResponseEntity<ProductModel> addBook(@RequestBody ProductModel produto) {
        try {
            ProductModel produtoObj = produtosRepository.save(produto);
            return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateProduto/{id}")
    public ResponseEntity<ProductModel> updateBook(@PathVariable Long id, @RequestBody ProductModel produto) {
        try {
            Optional<ProductModel> produtoData = produtosRepository.findById(id);
            if (produtoData.isPresent()) {
                ProductModel updatedProdutoData = produtoData.get();
                updatedProdutoData.setNome(produto.getNome());
                updatedProdutoData.setValor(produto.getValor());
                updatedProdutoData.setDescricao(produto.getDescricao());

                ProductModel produtoObj = produtosRepository.save(updatedProdutoData);
                return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProdutoById/{id}")
    public ResponseEntity<HttpStatus> deleteProduto(@PathVariable Long id) {
        try {
            produtosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllProdutos")
    public ResponseEntity<HttpStatus> deleteAllProdutos() {
        try {
            produtosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}



