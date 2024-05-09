package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.ProdutosModel;
import com.materialescolar.pi.exception.ResourceNotFoundException;

import com.materialescolar.pi.model.UserModel;
import com.materialescolar.pi.repository.ProdutosRepository;
import com.materialescolar.pi.repository.UserRepository;
import com.materialescolar.pi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProdutosController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping("/getAllProdutos")
    public ResponseEntity<List<ProdutosModel>> getAllProdutos() {
        try {
            List<ProdutosModel> listaDeProdutos = new ArrayList<>();
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
    public ResponseEntity<ProdutosModel> getProdutoById(@PathVariable Long id) {
        Optional<ProdutosModel> produtoObj = produtosRepository.findById(id);
        if (produtoObj.isPresent()) {
            return new ResponseEntity<>(produtoObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProduto")
    public ResponseEntity<ProdutosModel> addBook(@RequestBody ProdutosModel produto) {
        try {
            ProdutosModel produtoObj = produtosRepository.save(produto);
            return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateProduto/{id}")
    public ResponseEntity<ProdutosModel> updateBook(@PathVariable Long id, @RequestBody ProdutosModel produto) {
        try {
            Optional<ProdutosModel> produtoData = produtosRepository.findById(id);
            if (produtoData.isPresent()) {
                ProdutosModel updatedProdutoData = produtoData.get();
                updatedProdutoData.setNome(produto.getNome());
                updatedProdutoData.setValor(produto.getValor());
                updatedProdutoData.setDescricao(produto.getDescricao());

                ProdutosModel produtoObj = produtosRepository.save(updatedProdutoData);
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



